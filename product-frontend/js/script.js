var products = [];

var categories = [];

//format price
var formatter = new Intl.NumberFormat('pt-BR', {
  style: 'currency',
  currency: 'BRL',
});

//Convert to number
function convertToNumber(priceFormat){
  return priceFormat.replace(/\./g, '').replace(',', '.');
}

//On init
loadProducts();
loadCategories();

//Load all categories
function loadCategories(){
  $.getJSON("http://localhost:8080/categories", (response) => {
    categories = response;
    for(let cat of categories){
      document.getElementById("selectCategory").innerHTML += 
      `<option value="${cat.id}">${cat.name}</option>`
    }
  })
}

//load all products
function loadProducts(){
  $.getJSON("http://localhost:8080/products", (response) => {
    products = response;
    for(let prod of products){
        addNewRow(prod);
    }
  })
}

//save product
function save(){
  
  prod = {
    id: products.length + 1,
    name: document.getElementById("name").value,
    description: document.getElementById("description").value,
    price: convertToNumber(document.getElementById("price").value),
    category: categories[document.getElementById("selectCategory").value - 1],
    promotion: document.getElementById("checkBoxPromotion").checked,
    newProduct: document.getElementById("checkBoxNewProduct").checked,
  }

  $.ajax({
    url:"http://localhost:8080/products",
    type: "POST",
    async: true,
    contentType: "application/json",
    data: JSON.stringify(prod),
    success: (product) => {
      addNewRow(product);
      products.push(product);
      document.getElementById("formProduct").reset();
    }
  })

}

//add new row
function addNewRow(prod){
    var table = document.getElementById("productsTable");
    var newRow = table.insertRow();


    var idNode = document.createTextNode(prod.id);
    newRow.insertCell().appendChild(idNode);

    var nameNode = document.createTextNode(prod.name);
    newRow.insertCell().appendChild(nameNode);

    var descriptionNode = document.createTextNode(prod.description);
    var cell = newRow.insertCell();
    cell.className='d-none d-md-table-cell';
    cell.appendChild(descriptionNode);

    var priceNode = document.createTextNode(formatter.format(prod.price));
    newRow.insertCell().appendChild(priceNode);

    var categoryNode = document.createTextNode(prod.category.name);
    newRow.insertCell().appendChild(categoryNode);

    var options = '';
    if(prod.newProduct){
        options = '<span class="badge bg-primary me-1">L</span>'
    }

    if(prod.promotion){
        options += '<span class="badge bg-success">P</span>';
    }
    cell = newRow.insertCell();
    cell.className = 'd-none d-md-table-cell'
    cell.innerHTML = options;
}

//mask for price
$('#price').mask('000.000.000.000.000,00', {reverse: true});

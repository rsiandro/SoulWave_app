
async function consultarStock() {

  const url = 'api/stock';

  const request = await fetch (url,{
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
  });
  const articulos = await request.json();

  let listadoHtml = '';
  for (let articulo of articulos){

            let clearModif = articulo.modif.replace('T','@');

            let articuloHtml = '<tr><td>'+ articulo.id_art +'</td><td>'+ articulo.categoria +'</td><td>'+ articulo.marca +'</td><td>'+ articulo.modelo +'</td><td>'+ articulo.talle +'</td><td>'+ articulo.color +'</td><td>'+ articulo.id_proveedor +'</td><td>'+ clearModif +'</td></tr>';

            listadoHtml += articuloHtml;

    }

  document.querySelector('#tablaStock tbody').outerHTML = listadoHtml;

      $("#stockModal").modal("show");

  let table = new DataTable('#tablaStock', {});

}


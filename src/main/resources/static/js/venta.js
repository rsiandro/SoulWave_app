
async function consultarVentas() {

    let fechainiciovta = document.getElementById('fechainiciovta').value ;
    let fechafinvta = document.getElementById('fechafinvta').value;

    if (fechainiciovta == "" || fechafinvta == ""){
        alert ("Debe ingresar un rango de fechas.");
        window.location.href = 'productos.html'
    }

  const url = 'api/ventas?'+ $.param({fechainiciovta,fechafinvta});

  const request = await fetch (url,{
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
  });
  const ventas = await request.json();

  let listadoHtml = '';
  for (let venta of ventas){

            let clearFecha = venta.fechayhora.replace('T','@');

            let ventaHtml = '<tr><td>'+ venta.id_modelo +'</td><td>'+ venta.categoria +'</td><td>'+ venta.marca +'</td><td>'+ venta.modelo +'</td><td>'+ venta.talle +'</td><td>'+ venta.color +'</td><td>'+ clearFecha +'</td><td>'+ venta.id_usr +'</td></tr>';

            listadoHtml += ventaHtml;

    }

  document.querySelector('#tablaVentas tbody').outerHTML = listadoHtml;

      $("#ventasModal").modal("show");

  let table = new DataTable('#tablaVentas', {});

}


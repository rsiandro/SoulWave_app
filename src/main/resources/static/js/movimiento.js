
async function consultarMovimientos() {

  let fechainiciomov = document.getElementById('fechainiciomov').value ;
  let fechafinmov = document.getElementById('fechafinmov').value;

  const url = 'api/movimientos?'+ $.param({fechainiciomov,fechafinmov});

  const request = await fetch (url,{
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const movimientos = await request.json();

  let listadoHtml = '';
  for (let movimiento of movimientos){

    let clearFechayhora = movimiento.fechayhora.replace('T','@');

    let movimientoHtml = '<tr><td>'+ movimiento.id_mov +'</td><td>'+ clearFechayhora +'</td><td>'+ movimiento.tipo +'</td><td>'+ movimiento.id_usr +'</td><td>'+ movimiento.id_cliente +'</td></tr>';

    listadoHtml += movimientoHtml;

  }

  document.querySelector('#tablaMovimientos tbody').outerHTML = listadoHtml;

      $("#movimientosModal").modal("show");

  let table = new DataTable('#tablaMovimientos', {});

}


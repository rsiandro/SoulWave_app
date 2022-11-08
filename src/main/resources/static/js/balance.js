
async function consultarMovimientosBalance() {

  let fechainiciobal = document.getElementById('fechainiciobal').value ;
  let fechafinbal = document.getElementById('fechafinbal').value;

  let inEfectivo = document.getElementById('inEfectivo').checked;
  let inTarjeta = document.getElementById('inTarjeta').checked;
  let inTransferencia = document.getElementById('inTransferencia').checked;
  let inMercadoPago = document.getElementById('inMercadoPago').checked;

  let egEfectivo = document.getElementById('egEfectivo').checked;
  let egCheques = document.getElementById('egCheques').checked;
  let egTransferencia = document.getElementById('egTransferencia').checked;
  let egIVA = document.getElementById('egIVA').checked;
  let egDepositos = document.getElementById('egDepositos').checked;

  if (fechainiciobal == "" || fechafinbal == ""){
          alert ("Debe ingresar un rango de fechas.");
          window.location.href = 'caja.html'
      }

  const url = 'api/balance?'+ $.param({fechainiciobal,fechafinbal,inEfectivo,inTarjeta,inTransferencia,inMercadoPago,egEfectivo,egCheques,egTransferencia,egIVA,egDepositos});

  const request = await fetch (url,{
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const movimientosBalance = await request.json();

  let listadoHtml = '';
  let movimientoIngresoSuma = 0;
  let movimientoEgresoResta = 0;
  let total = 0;

  for (let movimientoB of movimientosBalance){

    let clearFechayhoraB = movimientoB.fechayhora.replace('T','@');

    if (movimientoB.tipo == 'ingreso'){

        let movimientoIngresoHtml = '<tr><td>'+ movimientoB.id_mov +'</td><td>'+ clearFechayhoraB +'</td><td>'+ movimientoB.nombre +'</td><td>'+ movimientoB.id_med +'</td><td>'+ movimientoB.tipo +'</td><td>'+ movimientoB.valor +'</td></tr>';

                listadoHtml += movimientoIngresoHtml;
                movimientoIngresoSuma = movimientoIngresoSuma + movimientoB.valor;

    } else if (movimientoB.tipo == 'egreso'){
        let movimientoEgresoHtml = '<tr><td>'+ movimientoB.id_mov +'</td><td>'+ clearFechayhoraB +'</td><td>'+ movimientoB.nombre +'</td><td>'+ movimientoB.id_med +'</td><td>'+ movimientoB.tipo +'</td><td>'+ movimientoB.valor +'</td></tr>';

                listadoHtml += movimientoEgresoHtml;
                movimientoEgresoResta = movimientoEgresoResta - movimientoB.valor;
    }
  }

   total = movimientoIngresoSuma + movimientoEgresoResta;

   console.log(movimientoIngresoSuma);
   console.log(movimientoEgresoResta);
   console.log(total);

  document.querySelector('#tablaBalance tbody').outerHTML = listadoHtml;

  if(movimientoIngresoSuma >= 1){
  document.querySelector('#tablaTotalBal tbody').outerHTML = '<td class = "h3 m-3 font-weight-normal"></td><td class = "h3 m-3 font-weight-normal"></td><td class = "h3 m-3 font-weight-normal text-right">Total</td><td class = "h3 m-3 font-weight-normal text-right">$</td><td class = "h3 m-3 font-weight-normal">'+ total +'</td>';
  } else {
  document.querySelector('#tablaTotalBal tbody').outerHTML = '<td class = "h3 m-3 font-weight-normal"></td><td class = "h3 m-3 font-weight-normal"></td><td class = "h3 m-3 font-weight-normal text-right">Total</td><td class = "h3 m-3 font-weight-normal text-right">$</td><td class = "h3 m-3 font-weight-normal"> - '+ total +'</td>';
  }
      $("#balanceModal").modal("show");

  let table = new DataTable('#tablaBalance', {});

}
$(document).ready(function(){
	url = '/objetos';
	listarObjetos(url);
});

function listarObjetos(url) {
	$.getJSON(url, function(data) {
		var qtd = data.length;
		for(i = 0; i < qtd; i++) {
			var linha = '<tr>' +
						'<td>'+ data[i].name + '</td>' +
						'<td>'+ data[i].codigo + '</td>' +
						'<td>'+ data[i].status + '</td>' +
						'<td>'+ data[i].id + '</td>' +
						'<td><a href="index.html?num='+ data[i].numeroObjeto + '">Editar</a></td>' +
					'</tr>';
			$("#tblObjetos > tbody").append(linha);
		}
	});
}

$("#btnPesq").click(function() {
	alert("clicou")
});

function pesquisarChamado(){
		$("#tblObjetos > tbody > tr").remove();
		url = '/objetos';
		listarObjetos(url);
}
window.addEventListener("load", iniciar);
var etapa;
function iniciar() {
    var etapaCompra = document.getElementById("etapaCompra").value;
    if (etapaCompra === "itensCarrinho") {
        $(".glyphicon-shopping-cart").addClass("glyphiconSelecionado");
    } else if (etapaCompra === "enderecoEntrega") {
        $(".glyphicon-envelope").addClass("glyphiconSelecionado");
    } else if (etapaCompra === "formaPagamento") {
        $(".glyphicon-usd").addClass("glyphiconSelecionado");
    } else if (etapaCompra === "resumoCompra") {
        $(".glyphicon-thumbs-up").addClass("glyphiconSelecionado");
    }

}
function calcValor(e, campo) {
    if (SomenteNumero(e)) {
        qtd = document.getElementById("quantidade").value;
        var whichCode = (window.Event) ? e.which : e.keyCode;
        qtd += String.fromCharCode(whichCode);
        preco = campo.selectedOptions[0].getAttribute("data-preco");
        result = parseFloat(preco * qtd).toFixed(2);
        document.getElementById("valor").value = result.replace(".", ",");
    } else {
        limpaCampos();
        return false;
    }

}
function SomenteNumero(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58))
        return true;
    else {
        if (tecla == 8 || tecla == 0)
            return true;
        else
            return false;
    }
}
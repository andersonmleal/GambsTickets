function buscarCEP() {
    var cep = document.getElementById("form_cadastro:cli_endereco_cep").value;
    if (cep === "" || cep.length < 8) {
        alert("Digite um CEP válido!");
    } else {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "https://viacep.com.br/ws/" + cep + "/xml", false);
        xhttp.send();
        xmlDoc = xhttp.responseXML;

        erro = xmlDoc.getElementsByTagName("erro");

        if (erro.length === 1) {
            alert("CEP digitado não encontrado!");
        } else {
            txt = xmlDoc.getElementsByTagName("logradouro");
            logradouro = txt[0].childNodes[0].nodeValue;
            txt = xmlDoc.getElementsByTagName("bairro");
            bairro = txt[0].childNodes[0].nodeValue;
            txt = xmlDoc.getElementsByTagName("localidade");
            cidade = txt[0].childNodes[0].nodeValue;
            txt = xmlDoc.getElementsByTagName("uf");
            uf = txt[0].childNodes[0].nodeValue;

            document.getElementById("form_cadastro:cli_logradouro").value = logradouro;
            document.getElementById("form_cadastro:cli_logradouro").readOnly = true;
            document.getElementById("form_cadastro:cli_endereco_bairro").value = bairro;
            document.getElementById("form_cadastro:cli_endereco_bairro").readOnly = true;
            document.getElementById("form_cadastro:cli_endereco_cidade").value = cidade;
            document.getElementById("form_cadastro:cli_endereco_cidade").readOnly = true;
            document.getElementById("form_cadastro:endereco_uf").value = uf;

        }
    }

}

function buscarCEPCompra() {
    var cep = document.getElementById("j_idt61:cep").value;
    alert(cep);
    return false;
    if (cep === "" || cep.length < 8) {
        alert("Digite um CEP válido!");
    } else {
        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "https://viacep.com.br/ws/" + cep + "/xml", false);
        xhttp.send();
        xmlDoc = xhttp.responseXML;

        erro = xmlDoc.getElementsByTagName("erro");

        if (erro.length === 1) {
            alert("CEP digitado não encontrado!");
        } else {
            txt = xmlDoc.getElementsByTagName("logradouro");
            logradouro = txt[0].childNodes[0].nodeValue;
            txt = xmlDoc.getElementsByTagName("bairro");
            bairro = txt[0].childNodes[0].nodeValue;
            txt = xmlDoc.getElementsByTagName("localidade");
            cidade = txt[0].childNodes[0].nodeValue;
            txt = xmlDoc.getElementsByTagName("uf");
            uf = txt[0].childNodes[0].nodeValue;

            document.getElementById("form_cadastro:cli_logradouro").value = logradouro;
            document.getElementById("form_cadastro:cli_logradouro").readOnly = true;
            document.getElementById("form_cadastro:cli_endereco_bairro").value = bairro;
            document.getElementById("form_cadastro:cli_endereco_bairro").readOnly = true;
            document.getElementById("form_cadastro:cli_endereco_cidade").value = cidade;
            document.getElementById("form_cadastro:cli_endereco_cidade").readOnly = true;
            document.getElementById("form_cadastro:endereco_uf").value = uf;

        }
    }

}




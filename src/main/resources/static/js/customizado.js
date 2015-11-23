    function limparMensagens() {
        $(".alert").each(function (a) {
          $(this).hide();
        });
      }
  
    function exibirMensagem(message, alert) {
        limparMensagens();
        if (alert) {
          alert.text(message).append('<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>').show();
        }
      }    

$(document).ready(function() {
    	limparMensagens();
    	$("#btnValidar").click(function(e){
    		e.preventDefault();
    		processarStream();
    	});
    });

    function processarStream() {
    	var texto = $('textarea[name="texto"]').val();
    	limparMensagens();
    	if(texto == ''){
    		exibirMensagem('Você ainda não digitou nada na caixa de texto.', $("#msgAlerta"));
    		return;
	    }
    	$.ajax({
            type: "POST",
            url: "/stream/"+texto,
            success: function(json) {
              if (json) {
            	  exibirMensagem('O primeiro caracter a não se repetir é : ' + json, $("#msgSucesso"));
              }
            },
            error: function(data) {
            	if (data.status == '404') {
            		exibirMensagem(data.responseJSON.message, $("#msgErro"));
            	}else{
            		exibirMensagem('Oocorreu um erro durante o processamento.', $("#msgErro"));
		        }
            }
          });
    }
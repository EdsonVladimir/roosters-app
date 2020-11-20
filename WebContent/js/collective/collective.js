const HttpRequest = {
    list() {
        return new Promise((resolve, reject) => {
            $.ajax({
                type: 'POST',
                url: './CollectiveServlet?accion=list',
                dataType: "json",
                success: function (data, textStatus, jqXHR) {
                    resolve(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    reject('Error en la petición')
                }
            });
        });
    },
	save(json) {
        return new Promise((resolve, reject) => {
            $.ajax({
                type: 'POST',
                url: './CollectiveServlet?accion=save',
                dataType: "json",
				data:{
					datos:JSON.stringify(json)
				},
                success: function (data, textStatus, jqXHR) {
                    resolve(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    reject('Error en la petición')
                }
            });
        });
    },
	delete(json) {
        return new Promise((resolve, reject) => {
            $.ajax({
                type: 'POST',
                url: './CollectiveServlet?accion=delete',
                dataType: "json",
				data:{
					datos:JSON.stringify(json)
				},
                success: function (data, textStatus, jqXHR) {
                    resolve(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    reject('Error en la petición')
                }
            });
        });
    },
	getDataCollective(json) {
        return new Promise((resolve, reject) => {
            $.ajax({
                type: 'POST',
                url: './CollectiveServlet?accion=getDataCollective',
                dataType: "json",
				data:{
					datos:JSON.stringify(json)
				},
                success: function (data, textStatus, jqXHR) {
                    resolve(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    reject('Error en la petición')
                }
            });
        });
    }
};


const DOMEvents = {
	init(){
		this.listCollectivesDatatable();
		this.bttnGuardar();
	},
	listCollectivesDatatable(){
		HttpRequest.list().then(data => {
			if(data.status){
				htmlBody = "";
				let dataXTable = data.data;
				for(let i in dataXTable){
					htmlBody += "<tr>";
					htmlBody += "<td>"+dataXTable[i].names+"</td>";
					htmlBody += "<td>"+dataXTable[i].organizator+"</td>";
					htmlBody += "<td>"+dataXTable[i].participators+"</td>";
					htmlBody += "<td>"+dataXTable[i].location+"</td>";
					htmlBody += '<td><a onClick="javascript:openModalUpdate('+dataXTable[i].id+')" class="btn btn-success-soft btn-sm mr-1"><i class="far fa-eye"></i>'+
					'</a><a href="#" class="btn btn-danger-soft btn-sm"><i class="far fa-trash-alt"></i></a></td>';
					htmlBody += "</tr>";
				}
				
				$("#tblCollectivesBody").html(htmlBody);
			}else{
				alert("Ha sucedido un error al obtener los datos.");
			}
		});
	},
	bttnGuardar(){
		$("#bttnGuardar").on("click", function(){
			let name = $("#txtName").val();
			let organizator = $("#txtOrganizator").val();
			let location = $("#txtLocation").val();
			
			if(name != "" && organizator != "" && location != ""){
				HttpRequest.save({namesR: name, organizatorR:organizator, locationR:location}).then(data =>{
					if(data.status){
						alert("Se inserto correctamente");
						window.location.reload();
					}
				});
			}else{
				alert("Tienes que completar todos los campos.");
			}
		});
	}
};


function openModalUpdate(codigo){	
	if(codigo != null){
		HttpRequest.getDataCollective({id:codigo}).then(data =>{
			if(data.status){
				$("#modal1").modal("show");
				$("#exampleModalLabel4").html("Actualizar colectivo");
				$("#txtName").val(data.data[0].names);
				$("#txtOrganizator").val(data.data[0].organizator);
				$("#txtLocation").val(data.data[0].location);	
			}else{
				alert("No se ha podido obtener los datos de este colectivo.");
			}
		});
	}
}

init = () => {
    DOMEvents.init();
	HttpRequest.list();
};
init();
const HttpRequest = {
    list() {
        return new Promise((resolve, reject) => {
            $.ajax({
                type: 'POST',
                url: './CollectiveServlet?accion=list',
                dataType: "json",
                success: function (data, textStatus, jqXHR) {
                    resolve(data)
					console.log(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    reject('Error en la petición')
                }
            });
        });
    },
};


const DOMEvents = {
	init(){
		
	}
};




init = () => {
    DOMEvents.init();
	HttpRequest.list();
};
init();
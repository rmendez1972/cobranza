angular.module('CobranzaApp.modalx', []).
  factory('modalx', function($rootScope) {
	var modalAPI = {};
        
    modalAPI.confirm = function(titulo, contenido, si, no) {
        var mod=new Object();
        mod.titulo=titulo;
        mod.contenido=contenido;
        mod.si=si;
        mod.no=no;
        
        $rootScope.mod=mod;
        $("#ventanaModal").modal();
    }

    return modalAPI;
    
  });
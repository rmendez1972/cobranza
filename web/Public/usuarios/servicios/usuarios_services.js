angular.module('CobranzaApp.services', []).
  factory('servicioCobranza', function($http) {
	var cobranzaAPI = {};

    cobranzaAPI.getUsuarios = function() {
        return $http.get('controladorusuarios?operacion=getall');
    }
    
        
    cobranzaAPI.getOne = function(id_usuario) {
        return $http.get('controladorusuarios?operacion=getone&idusuario='+id_usuario);
    }
    
    cobranzaAPI.obtenerDelegaciones = function(){
        return $http.get("controladordelegacion?operacion=getall");
    }
    
    cobranzaAPI.obtenerNiveles = function(){
        return $http.get("controladornivel?operacion=getall");
    }
    
    
    
    cobranzaAPI.guardarNuevo = function(datos){
        
        return $http({
           method: "POST",
           url: "controladorusuarios?operacion=nuevo",
           data: $.param(datos),
           headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'}
        });
    }
    
    cobranzaAPI.guardarEdit = function(datos){
        return $http({
            method: "POST",
            url: "controladorusuarios?operacion=editar",
            data: $.param(datos),
            headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'}
        });
    }
    
    cobranzaAPI.eliminarUsuario = function(id_usuario) {
        
        return $http.get('controladorusuarios?operacion=eliminar&idusuario='+id_usuario);
    }

    return cobranzaAPI;
    
  });
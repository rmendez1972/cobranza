angular.module('CobranzaApp.services', []).
  factory('servicioCobranza', function($http) {
	var cobranzaAPI = {};

    cobranzaAPI.getModulos = function() {
        return $http.get('controladormodulosrec?operacion=getall');
    }
    
        
    cobranzaAPI.getOne = function(id_modulo) {
        return $http.get('controladormodulosrec?operacion=getone&idmodulo='+id_modulo);
    }
    
    cobranzaAPI.obtenerDelegaciones = function(){
        return $http.get("controladordelegacion?operacion=getall");
    }
    
    cobranzaAPI.guardarNuevo = function(datos){
        return $http({
           method: "POST",
           url: "controladormodulosrec?operacion=nuevo",
           data: $.param(datos),
           headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'}
        });
    }
    
    cobranzaAPI.guardarEdit = function(datos){
        return $http({
            method: "POST",
            url: "controladormodulosrec?operacion=editar",
            data: $.param(datos),
            headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'}
        });
    }
    
    cobranzaAPI.eliminarModulo = function(id_modulo) {
        return $http.get('controladormodulosrec?operacion=eliminar&idmodulo='+id_modulo);
    }

    return cobranzaAPI;
    
  });
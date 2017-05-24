angular.module('CobranzaApp.services', []).
  factory('servicioCobranza', function($http) {
	var cobranzaAPI = {};
    
    cobranzaAPI.getOne = function(id_delegacion) {
        return $http.get('controladordelegacion?operacion=getone&id_delegacion='+id_delegacion);
    }
    
    cobranzaAPI.obtenerDelegaciones = function(){
        return $http.get("controladordelegacion?operacion=getall");
    }
    
    cobranzaAPI.guardarNuevo = function(datos){
        return $http({
           method: "POST",
           url: "controladordelegacion?operacion=nuevo",
           data: $.param(datos),
           headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'}
        });
    }
    
    cobranzaAPI.guardarEdit = function(datos){
        return $http({
            method: "POST",
            url: "controladordelegacion?operacion=editar",
            data: $.param(datos),
            headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8'}
        });
    }
    
    cobranzaAPI.eliminarModulo = function(id_delegacion) {
        return $http.get('controladordelegacion?operacion=eliminar&id_delegacion='+id_delegacion);
    }

    return cobranzaAPI;
    
  });
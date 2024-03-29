angular.module('CobranzaApp.controllers', []).
controller('oficinasController', function($scope,  $modal, $log,  ngTableParams, servicioCobranza, $timeout) {
        
    $scope.delegaciones=[];
    $scope.campo="-descripcion";
    $scope.accion="listar";
    
    $scope.oficinaNew=null;
    $scope.oficinaAct=null;
    $scope.alerts=[];
    
    
    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    };
    
    $scope.tooltip_descripcion={
            "title": "Ingresa el nombre de la oficina",
            "checked": false
        };
    $scope.tooltip_direccion={
            "title": "Ingresa la direccion de la oficina",
            "checked": false
        };
    
    servicioCobranza.obtenerDelegaciones().success(function (response){
       $scope.delegaciones=response; 
    });

    $scope.nuevo=function(){
        $scope.alerts=[];
        $scope.oficinaNew=null;
        $scope.accion='nuevo';
        $scope.nuevaOficina.$setPristine();
    }

    $scope.guardarNuevo=function(){
        $scope.alerts=[];
        servicioCobranza.guardarNuevo($scope.oficinaNew).success(function(response){
            $scope.selected=true;
            if(response=="true"){
                $scope.alerts.push({type: 'success', msg: 'Datos guardados.'});
                
                servicioCobranza.obtenerDelegaciones().success(function (response){
                    $scope.delegaciones=response; 
                 });
    
                $scope.accion="listar";
            }
             else{
                $scope.alerts.push({type: 'success', msg: 'Error al guardar los datos'});
            }
            
            $timeout(function()
                {
                    $scope.alerts=[];
                }, 3000); 
        });
    }

    $scope.guardarEdit=function(){
        $scope.alerts=[];
        servicioCobranza.guardarEdit($scope.oficinaAct).success(function(response){
            $scope.selected=true;
            if(response=="true"){
                $scope.alerts.push({type: 'success', msg: 'Datos guardados.'});
                
                servicioCobranza.obtenerDelegaciones().success(function (response){
                    $scope.delegaciones=response; 
                 });
                $scope.accion="listar";
            }
            else{
                $scope.alerts.push({type: 'success', msg: 'Error al guardar los datos'});
            }
            
            $timeout(function()
                {
                    $scope.alerts=[];
                }, 3000); 
        });
    }

    $scope.editar=function(id_delegacion){
        $scope.alerts=[];
        servicioCobranza.getOne(id_delegacion).success(function(response){
            $scope.oficinaAct=response;
            $scope.accion="editar";
            $scope.editarOficina.$setPristine();
        });
    }

    
    
    $scope.eliminar=function(id_delegacion){
        $scope.alerts=[];
        
        var modalInstance = $modal.open({
        templateUrl: 'myModalContent.html',
        controller: 'ModalInstanceCtrl as ic',
        size: 'sm',
        resolve: {
            eliminarModulo: function () {
                return $scope.eliminarModulo;
                               }
                 }
      });
      
      modalInstance.result.then(function (selectedItem) {
        $scope.selected = selectedItem;
        
        
        if($scope.selected==true){
            
            servicioCobranza.eliminarModulo(id_delegacion).success(function(response){
                if(response=="true"){
                    $scope.alerts.push({type: 'success', msg: 'Oficina eliminada exitosamente'});
                    
                    servicioCobranza.obtenerDelegaciones().success(function (response){
                        $scope.delegaciones=response; 
                     });
                }
                else{
                    $scope.alerts.push({type: 'success', msg: 'Error al eliminar'});
                    
                }
                $timeout(function()
                {
                    $scope.alerts=[];
                }, 3000); 
            });
        }
    }, function () {
      $log.info('Modal dismissed at: ' + new Date());
    });
         
    }
});

angular.module('CobranzaApp.controllers').controller('ModalInstanceCtrl', function ( $scope, $modalInstance) {

  $scope.selected=false;
  $scope.ok = function () {
    $scope.selected=true;  
    $modalInstance.close($scope.selected);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});
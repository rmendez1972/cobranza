angular.module('CobranzaApp.controllers', []).
controller('modulosController', function($scope,  $modal, $log, $timeout,  ngTableParams, servicioCobranza) {
    
    
    //metodo que cierra el alert
    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    };
    
    
    var data=null;
    $scope.modulos=[]; //vector de json's
    $scope.campo="-descripcion";
    $scope.accion="listar";
    $scope.moduloNuevo=null;
    $scope.moduloAct=null;
    $scope.editarModulo=null;
    $scope.eliminarModulo=null;
    
    
    

    
    
    servicioCobranza.getModulos().success(function (response) {
        
        $scope.modulos = response;
        $scope.selected=false;
        data=response; //variable que contiene el arreglo de json´s, que van a ser cortados para la paginación
       
        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: 10           // count per page
        }, 
        {
            
            total: data.length, // length of data
            getData: function($defer, params) {
             params.settings({ counts: data.length > 10 ? [10,20] : [10,20]});    
            $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
            }
        });
        
    });
    
    
    
    
    servicioCobranza.obtenerDelegaciones().success(function (response){
       $scope.delegaciones=response;
       $scope.selected=false;
    });

    $scope.nuevo=function(){
        $scope.alerts = [];
        $scope.selected=false;
        $scope.moduloNuevo=new Object();
        $scope.moduloNuevo.id_delegacion=1;
        $scope.moduloNuevo.alert=false;
        $scope.accion='nuevo';
        $scope.nuevoModulo.$setPristine();
        var data=null;
    }

    $scope.guardarNuevo=function(){
        
        $scope.alerts = [];
        $scope.selected=false;
        servicioCobranza.guardarNuevo($scope.moduloNuevo).success(function(response){
            
            if(response=="true"){
                
                var data=null;
                $scope.moduloNuevo.alert=true;
                $scope.editarModulo.alert=false;
                $scope.alerts.push({type: 'success', msg: 'Datos Grabados exitosamente al agregar nuevo modulo!'});
                //metodo que cierra en automatico el alert recientemente ingresado al vector alerts
                $timeout(function()
                {
                    $scope.alerts.splice($scope.alerts.indexOf({type: 'success', msg: 'Datos Grabados exitosamente!'}), 1);
                }, 3000);
                $scope.selected=true;
                $scope.accion="listar";
                $scope.modulos=[];
                servicioCobranza.getModulos().success(function (response) {
                    
                    $scope.modulos = response;
                    $scope.selected=false;
                    data=response; //variable que contiene el arreglo de json´s, que van a ser cortados para la paginación
                    $scope.tableParams=null;
                    $scope.tableParams = new ngTableParams({
                        page: 1,            // show first page
                        count: 10           // count per page
                    }, 
                    {

                        total: data.length, // length of data
                        getData: function($defer, params) {
                        params.settings({ counts: data.length > 1 ? [10,20] : [10,20]});    
                        $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                        }
                    });

                });
                
            }
             else{
                
                $scope.moduloNuevo.alert=true;
                $scope.editarModulo.alert=false;
                $scope.alerts.push({type: 'danger', msg: 'Error al grabar los datos!'});
                //metodo que cierra en automatico el alert recientemente ingresado al vector alerts
                $timeout(function()
                {
                    $scope.alerts.splice($scope.alerts.indexOf({type: 'danger', msg: 'Error al grabar los datos!'}), 1);
                }, 3000);
                $scope.selected=false;
            }
        });
    }

    $scope.guardarEdit=function(){
        $scope.alerts = [];
        $scope.selected=false;
        data=null;
        servicioCobranza.guardarEdit($scope.moduloAct).success(function(response){
            if(response=="true"){
                //alert("Datos guardados");
                $scope.editarModulo.alert=true;
                $scope.moduloNuevo.alert=false;
                $scope.alerts.push({type: 'success', msg: 'Datos actualizados exitosamente!'});
                //metodo que cierra en automatico el alert recientemente ingresado al vector alerts
                $timeout(function()
                {
                    $scope.alerts.splice($scope.alerts.indexOf({type: 'success', msg: 'Datos actualizados exitosamente!'}), 1);
                }, 3000);
                $scope.selected=false;
                servicioCobranza.getModulos().success(function (response) {
                        $scope.modulos = response;
                        data=response;
       
                        $scope.tableParams = new ngTableParams({
                            page: 1,            // show first page
                            count: 10           // count per page
                        }, 
                        {
                            total: data.length, // length of data
                            getData: function($defer, params) {
                                params.settings({ counts: data.length > 10 ? [10,20] : [10,20]});
                                $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                            }
                        });
                    });
                $scope.accion="listar";
            }
            else{
                //alert("Error al guardar los datos");
                $scope.editarModulo.alert=true;
                $scope.moduloNuevo.alert=false;
                $scope.alerts.push({type: 'danger', msg: 'Error al grabar los datos!'});
                //metodo que cierra en automatico el alert recientemente ingresado al vector alerts
                $timeout(function()
                {
                    $scope.alerts.splice($scope.alerts.indexOf({type: 'danger', msg: 'Error al grabar los datos!'}), 1);
                }, 3000);
                $scope.selected=false;
                
            }
        });
    }

    $scope.editar=function(id_modulo){
            
            $scope.alerts = [];
            $scope.selected=false;
            servicioCobranza.getOne(id_modulo).success(function(response){
            $scope.moduloAct=response;
            $scope.accion="editar";
            $scope.editarModulo.$setPristine();
            $scope.editarModulo.alert=false;
            $scope.moduloNuevo.alert=false;
            
        });
    }

    
    
    $scope.eliminar=function(id_modulo){
      $scope.alerts = [];  
      
      $scope.selected=false;
      $scope.editarModulo.alert=false;
      $scope.moduloNuevo.alert=false;
      
      
      
      var modalInstance = $modal.open({
        templateUrl: 'myModalContent.html',
        controller: 'ModalInstanceCtrl as ic',
        size: 'lg',
        resolve: {
            eliminarModulo: function () {
                return $scope.eliminarModulo;
                               }
                 }
      });
    
    modalInstance.result.then(function (selectedItem) {
        $scope.selected = selectedItem;
        
        
        if($scope.selected==true){
            
            servicioCobranza.eliminarModulo(id_modulo).success(function(response){
                if(response=="true"){
                    $scope.alerts.push({type: 'success', msg: 'Modulo eliminado exitosamente!'});
                    //metodo que cierra en automatico el alert recientemente ingresado al vector alerts
                    $timeout(function()
                    {
                      $scope.alerts.splice($scope.alerts.indexOf({type: 'success', msg: 'Modulo eliminado exitosamente!'}), 1);
                    }, 3000);
                    
                    servicioCobranza.getModulos().success(function (response) {
                        $scope.modulos = response;
                        data=response;

                        $scope.tableParams = new ngTableParams({
                            page: 1,            // show first page
                            count: 10           // count per page
                        }, 
                        {
                            total: data.length, // length of data
                            getData: function($defer, params) {
                                params.settings({ counts: data.length > 10 ? [10,20] : [10,20]});
                                $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                            }
                        });
                    
                    
                    });
                    $scope.accion="listar";
                    
                }
                else{
                    //alert("Error al eliminar");
                    $scope.alerts.push({type: 'danger', msg: 'Error al eliminar módulo!'});
                    //metodo que cierra en automatico el alert recientemente ingresado al vector alerts
                    $timeout(function()
                    {
                      $scope.alerts.splice($scope.alerts.indexOf({type: 'danger', msg: 'Error al eliminar módulo!'}), 1);
                    }, 3000);
                }
            });
        }
    }, function () {
      $log.info('Modal dismissed at: ' + new Date());
    });
         
        
    }
    
    
});



angular.module('CobranzaApp.controllers').controller('ModalInstanceCtrl', function ( $scope, $modalInstance, eliminarModulo) {

  $scope.selected=false;
  $scope.ok = function () {
    $scope.selected=true;  
    $modalInstance.close($scope.selected);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});


angular.module('CobranzaApp.controllers').controller('OtherController', function ( $scope) {
  $scope.pageChangeHandler = function(num) {
    console.log('going to page ' + num);
  };
});
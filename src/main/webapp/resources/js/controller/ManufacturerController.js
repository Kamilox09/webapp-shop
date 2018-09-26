var myApp = angular.module('myApp',[]);
myApp.controller('manufacturerCtrl',function($scope,$http){
    $scope.obj={};
    $scope.obj.name='';
    $scope.error=false;
    $scope.manufacturers={};
    $scope.old={};
    $scope.del={};
    $scope.del.manufacturerId='';
    $scope.del.name='';



    $scope.addManufacturer = function(obj){
        $http.post('/mywebapp/admin/manufacturer',obj)
            .then(function(){
                $scope.reset();
                window.location.reload();
            })
            .catch(function(){failureCallback();
            })
    };

    $scope.setObjToDel = function(id,name){
        $scope.del.manufacturerId=id;
        $scope.name=name;
    };

    $scope.editManufacturer = function(obj){
        $scope.obj.manufacturerId=$scope.old.manufacturerId;
        $http.put('/mywebapp/admin/manufacturer',obj)
            .then(function(){
                $scope.reset();
                window.location='/mywebapp/admin/manufacturer';
            })
            .catch(function(){
                failureCallback();
            })
    };

    $scope.deleteManufacturer = function(){
        $http.delete('/mywebapp/admin/manufacturer?id='+$scope.del.manufacturerId)
            .then(function(){
                $scope.reset();
                window.location.reload();
            })
    };

    $scope.getAllManufacturers = function(){
        $http.get('/mywebapp/admin/manufacturer/all')
            .then(function(data){
                $scope.manufacturers=data.data;
            })
    };

    $scope.getOld = function(){
        var url = window.location.pathname;
        var id= url.substring(url.lastIndexOf('/')+1);
        $http.get('/mywebapp/admin/manufacturer/get/'+id)
            .then(function(response){
                $scope.old=response.data;
                $scope.obj.name=$scope.old.name;
            })

    };

    $scope.reset=function(){
        $scope.obj={};
        $scope.obj.name='';
        $scope.error=false;
        $scope.old={};
        $scope.del={};
        $scope.del.manufacturerId='';
        $scope.del.name='';
    };

    var failureCallback = function(){
        $scope.error=true;
    }
});
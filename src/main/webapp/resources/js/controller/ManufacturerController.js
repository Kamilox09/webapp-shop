var myApp = angular.module('myApp',[]);
myApp.controller('manufacturerCtrl',function($scope,$http){
    $scope.obj={};
    $scope.obj.name='';
    $scope.error=false;
    $scope.manufacturers={};

    $scope.addManufacturer = function(obj){
        $http.post('/mywebapp/admin/manufacturer',obj)
            .then(function(){
                $scope.reset();
                window.location.reload();
            },
                failureCallback())
    };

    $scope.getAllManufacturers = function(){
        $http.get('/mywebapp/admin/manufacturer/all')
            .then(function(data){
                $scope.manufacturers=data.data;
            })
    };

    $scope.reset=function(){
        $scope.obj={};
        $scope.obj.name='';
        $scope.error=false;
    };

    var failureCallback = function(){
        $scope.error=true;
    }
});
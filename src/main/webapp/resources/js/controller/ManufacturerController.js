var myApp = angular.module('myApp',[]);
myApp.controller('manufacturerCtrl',function($scope,$http){
    $scope.obj={};
    $scope.obj.name='';
    $scope.error=false;

    $scope.addManufacturer = function(obj){
        $http.post('/mywebapp/admin/manufacturer',obj)
            .then(function(){
                $scope.reset();
                window.location.reload();
            },
                failureCallback())
    };

    $scope.reset=function(){
        $scope.obj={};
        $scope.obj.name='';
        $scope.error=false;
    }

    var failureCallback = function(){
        $scope.error=true;
    }
});
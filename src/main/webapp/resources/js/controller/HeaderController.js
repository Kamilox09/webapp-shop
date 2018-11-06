angular.module('myApp').controller('headerCtrl',function($scope,$http){
    $scope.logged=false;
    $scope.username="";

    $scope.getUser=function () {
        $http.get('/mywebapp/sessiondetails')
            .then(function(response){
                $scope.username=response.data.username;
                if($scope.username!==""){
                    $scope.logged=true;
                }else{
                    $scope.logged=false;
                }
            })
    };







});
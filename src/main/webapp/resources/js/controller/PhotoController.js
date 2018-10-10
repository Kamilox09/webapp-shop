angular.module('myApp').controller('photoCtrl',function ($scope,$http) {
    $scope.photo={};
    $scope.photo.photo=null;

    $scope.sendPhoto = function(obj){
        var url = window.location.pathname;
        var id= url.substring(url.lastIndexOf('/')+1);
        $http.post('/mywebapp/admin/photo'+id,obj)
            .then(function(response){
                $scope.reset();
                window.location.reload();
            })
    };

    $scope.reset=function(){
        $scope.photo={};
        $scope.photo.photo=null;
    };
});
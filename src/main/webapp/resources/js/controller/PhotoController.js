angular.module('myApp').controller('photoCtrl',function ($scope,$http) {


    $scope.sendPhoto = function(obj){
        var url = window.location.pathname;
        var id= url.substring(url.lastIndexOf('/')+1);
        var config = {headers: {'Content-Type': undefined },
            transformRequest: angular.identity};
        var fd = new FormData();
        fd.append('file',obj);
        $http.post('/mywebapp/admin/photo/'+id,fd,config)
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

angular.module('myApp').directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);
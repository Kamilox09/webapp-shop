//var myApp = angular.module('myApp',[]);
angular.module('myApp').controller('categoryCtrl',function($scope,$http){
    $scope.obj={};
    $scope.obj.name='';
    $scope.error=false;
    $scope.categories={};
    $scope.old={};
    $scope.del={};
    $scope.del.categoryId='';
    $scope.del.name='';



    $scope.addCategory = function(obj){
        $http.post('/mywebapp/admin/category',obj)
            .then(function(){
                $scope.reset();
                window.location.reload();
            })
            .catch(function(){failureCallback();
            })
    };

    $scope.setObjToDel = function(id,name){
        $scope.del.categoryId=id;
        $scope.del.name=name;
    };

    $scope.editCategory = function(obj){
        $scope.obj.categoryId=$scope.old.categoryId;
        $http.put('/mywebapp/admin/category',obj)
            .then(function(){
                $scope.reset();
                window.location='/mywebapp/admin/category';
            })
            .catch(function(){
                failureCallback();
            })
    };

    $scope.deleteCategory = function(){
        $http.delete('/mywebapp/admin/category?id='+$scope.del.categoryId)
            .then(function(){
                $scope.reset();
                window.location.reload();
            })
    };

    $scope.getAllCategories = function(){
        $http.get('/mywebapp/admin/category/all')
            .then(function(data){
                $scope.categories=data.data;
            })
    };

    $scope.getOld = function(){
        var url = window.location.pathname;
        var id= url.substring(url.lastIndexOf('/')+1);
        $http.get('/mywebapp/admin/category/get/'+id)
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
        $scope.del.categoryId='';
        $scope.del.name='';
    };

    var failureCallback = function(){
        $scope.error=true;
    }
});
angular.module('myApp').controller('cartCtrl',function($scope,$http) {
    $scope.lines = {};
    $scope.cart={};


    $scope.checkCartAndGetLines = function () {
        $http.get("/mywebapp/cart/check")
            .then(function(response) {
                $scope.cart=response.data;

                $http.get('/mywebapp/cart/getlines/'+$scope.cart.cartId)
                    .then(function(response){
                        $scope.lines=response.data;
                    })
            })
    };

    $scope.deleteOrderLine = function(id){
      $http.delete('/mywebapp/cart?id='+id)
          .then(function(){
              var i,ind;
              for(i=0;$scope.lines.length;i++){
                if($scope.lines[i].orderLineId===id){
                    ind=i;
                    break;
                }
              }
              $scope.lines.splice(ind,1);
          })
    };



});
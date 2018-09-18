
var myApp = angular.module('myApp',[]);
myApp.controller('registryCtrl',function($scope,$http){
    var areTheSame = false;
    $scope.acc={};
    $scope.acc.login='';
    $scope.acc.password='';
    $scope.pass2='';
    $scope.acc.email='';
    $scope.acc.name='';
    $scope.acc.surname='';
    $scope.acc.company='';
    $scope.acc.nip='';
    $scope.acc.regon='';
    $scope.acc.city='';
    $scope.acc.zipCode='';
    $scope.acc.street='';
    $scope.acc.localNumber='';

    $scope.sendForm = function(accountDetails){
        checkPasswords();
        if(areTheSame){
            $http.post('/mywebapp/register',accountDetails)
                .then(function (response) {
                    $scope.reset();
                    window.location='/mywebapp/login';
                });
        }
    };

    var checkPasswords = function () {
       // if($scope.acc.password===$scope.pass2){
        //    areTheSame = true;
        //}
       // else{
       //     areTheSame=false;
       // }
        areTheSame = $scope.acc.password===$scope.pass2;
    };

    $scope.reset=function(){
        areTheSame = false;
        $scope.acc={};
        $scope.acc.login='';
        $scope.acc.password='';
        $scope.pass2='';
        $scope.acc.email='';
        $scope.acc.name='';
        $scope.acc.surname='';
        $scope.acc.company='';
        $scope.acc.nip='';
        $scope.acc.regon='';
        $scope.acc.city='';
        $scope.acc.zipCode='';
        $scope.acc.street='';
        $scope.acc.localNumber='';
    };
    });
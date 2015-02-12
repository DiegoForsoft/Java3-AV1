var app = angular.module('loja', ['ngRoute']);

app.config(function($routeProvider) {
    
    $routeProvider.when('/', {
        templateUrl: 'partials/bem-vindo.tpl.html'
    });
    
    $routeProvider.when('/cadastro-veiculo', {
        templateUrl: 'partials/cadastro-veiculo.tpl.html',
        controller: 'FuncionarioController' 
    });
                         
    $routeProvider.otherwise({redirectTo: '/'});
    
});
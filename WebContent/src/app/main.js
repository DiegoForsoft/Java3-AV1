var app = angular.module('loja', ['ngRoute']);

app.config(function($routeProvider) {
    
    $routeProvider.when('/', {
        templateUrl: 'visual/partials/bem-vindo.tpl.html'
    });
    
    $routeProvider.when('/cadastro-veiculo', {
        templateUrl: 'visual/partials/cadastro-veiculo.tpl.html',
        controller: 'CadastrarVeiculo' 
    });
                         
    $routeProvider.otherwise({redirectTo: '/'});
    
});
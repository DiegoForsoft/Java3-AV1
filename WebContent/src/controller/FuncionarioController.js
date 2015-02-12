app.controller('FuncionarioController', function($scope) {
    
    $scope.funcionarios = [
        {nome: 'Maria', idade: 18},
        {nome: 'Jose', idade: 20},
        {nome: 'Mariana', idade: 21},
        {nome: 'Batman', idade: 50}
    ];
    
    $scope.selecionado = true;
});
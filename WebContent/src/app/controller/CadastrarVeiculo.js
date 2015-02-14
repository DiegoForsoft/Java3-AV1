app.controller('CadastrarVeiculo', function($scope) {
    
    $scope.tipoDeVeiculos = ['Carro', 'Motocicleta'];
    
	$scope.opcoes = {
		modelo: ['Sedan', 'Fiesta'],
		cor: ['Rosa', 'Vermelho', 'Azul'],
        cambio: ['teste1', 'teste2']
	};
});
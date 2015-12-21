App.controller('CategoryController', ['$scope', 'СategoryService', function($scope, СategoryService) {
var self = this;
self.Category={id:null,name:''};
self.Categories=[];

self.fetchAllCategories = function(){
    СategoryService.fetchAllCategories()
        .then(
        function(d) {
            self.Categories = d;
        },
        function(errResponse){
            console.error('Error while fetching Currencies');
        }
    );
};

self.createCategory = function(Category){
    СategoryService.createCategory(Category)
        .then(
        self.fetchAllCategories,
        function(errResponse){
            console.error('Error while creating Category.');
        }
    );
};

self.updateCategory = function(Category, id){
    СategoryService.updateCategory(Category, id)
        .then(
        self.fetchAllCategories,
        function(errResponse){
            console.error('Error while updating Category.');
        }
    );
};

self.deleteCategory = function(id){
    СategoryService.deleteCategory(id)
        .then(
        self.fetchAllCategories,
        function(errResponse){
            console.error('Error while deleting Category.');
        }
    );
};

self.fetchAllCategories();

self.submit = function() {
    if(self.Category.id==null){
        console.log('Saving New Category', self.Category);
        self.createCategory(self.Category);
    }else{
        self.updateCategory(self.Category, self.Category.id);
        console.log('Category updated with id ', self.Category.id);
    }
    self.reset();
};

self.edit = function(id){
    console.log('id to be edited', id);
    for(var i = 0; i < self.Categories.length; i++){
        if(self.Categories[i].id == id) {
            self.Category = angular.copy(self.Categories[i]);
            break;
        }
    }
};

self.remove = function(id){
    console.log('id to be deleted', id);
    for(var i = 0; i < self.Categories.length; i++){//clean form if the Category to be deleted is shown there.
        if(self.Categories[i].id == id) {
            self.reset();
            break;
        }
    }
    self.deleteCategory(id);
};


self.reset = function(){
    self.Category={id:null,Categoryname:'',address:'',email:''};
    $scope.myForm.$setPristine(); //reset Form
};

}]);
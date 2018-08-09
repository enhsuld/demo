angular
    .module('altairApp')
    .controller("LutExpProgcategoryCtrl",['$rootScope','$scope','$timeout','mainService','$state','$cookies','gridService','__env',
        function ($rootScope,$scope,$timeout,mainService,$state,$cookies,gridService,__env) {
            $rootScope.toBarActive = true;
            $rootScope.topMenuActive = true;

         
            $scope.LutExpProgcategoryGridOptions = {
                sortable: true,
                resizable: true,
                columnMenu:true,
                persistSelection: true,
                filterable: {
                    extra: false,
                    operators: {
                        string: {
                            contains: "Агуулсан",
                            startswith: "Эхлэх утгаар",
                            eq: "Тэнцүү"
                        }
                    }
                },
                scrollable: {
                    virtual: true
                },
                pageable: {
                    pageSizes: [50, 100],
                    refresh: true,
                    buttonCount: 5,
                    message: {
                        empty: 'No Data',
                        allPages: 'All'
                    }
                },
                height: function () {
                    return $(window).height() - 175;
                },
                columns: [
                    {field: "applNo", title: "Дугаар", hidden:false,width: 120, headerAttributes: {style: "text-align: center; font-weight: bold"}},
                    
                ],
                editable: true,
                dataBound: function () {
                    var rows = this.items();
                    $(rows).each(function () {
                        var index = $(this).index() + 1
                            + ($("#ldiApply").data("kendoGrid").dataSource.pageSize() * ($("#ldiApply").data("kendoGrid").dataSource.page() - 1));
                        var rowLabel = $(this).find(".row-number");
                        $(rowLabel).html(index);
                    });
                }
            };
        }
    ]);

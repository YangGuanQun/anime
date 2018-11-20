var queryByPage = function (request) {
    if (!request) {
        request = {
            ani: {
                watchState: 1
            },
            tags: ['动画']
        };
    }
    AniUtil.queryAniByPage(request, function (result) {
        app.aniList = result.resultList;
    }, function () {
        alert("failed");
    });
};

var app = new Vue({
    el: '#app',
    data: {
        aniList: [],
        contextMenuFlag: false,
        currentFoucsRowId: ""
    },
    created: function () {
        window.onmousedown = function () {
            return false;
        };
        window.onmouseup = function () {
            if (window.event) {
                if (0 === event.button) {
                    app.contextMenuFlag = false;
                }
            }
            return false;
        };
        var _request = {
            ani: {
                watchState: 1
            },
            tags: ['动画']
        };
        queryByPage(_request);
        AniUtil.total(function(data){
           parent.nav.total=data;
        },function(){

        });
    },
    methods: {
        trRightClick: function (id, event, isOper) {
            app.currentFoucsRowId = id;
            if (isOper || 2 === event.button) {
                app.contextMenuFlag = true;
                $('#context-menu').css({"left": event.clientX, "top": event.clientY})
            }
        }
    }
});


var plusOne = function () {
    AniUtil.plusOne(app.currentFoucsRowId, function () {
        queryByPage();
    }, function () {
        alert("failed");
    });
};
var markFinState = function () {
    var _request = {
        id:app.currentFoucsRowId,
        finState:AniUtil.FIN_STATE.FIN_STATE_FIN
    };
    AniUtil.modifyAni(_request,function(){
        queryByPage();
    },function(){
        alert("failed");
    });
};
var markWatchState = function () {
    var _request = {
        id:app.currentFoucsRowId,
        watchState:AniUtil.WATCH_STATE.WATCH_STATE_FINISH
    };
    AniUtil.modifyAni(_request,function(){
        queryByPage();
    },function(){
        alert("failed");
    });
}
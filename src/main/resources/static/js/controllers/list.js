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
                $('#context-menu').css({"left": event.clientX, "top": event.clientY + document.documentElement.scrollTop})
            }
        },
        getStateContent :function (ani) {
            if (ani.finState === AniUtil.FIN_STATE.FIN_STATE_COMING) {
                return "尚未播出";
            } else if (ani.finState === AniUtil.FIN_STATE.FIN_STATE_FIN) {
                if (ani.watchState === AniUtil.WATCH_STATE.WATCH_STATE_FINISH) {
                    return "完结 " + ani.episodeNum + " 话";
                } else if (ani.watchState === AniUtil.WATCH_STATE.WATCH_STATE_BEFORE) {
                    return "已完结 尚未观看"
                } else if (ani.watchState === AniUtil.WATCH_STATE.WATCH_STATE_CHASING) {
                    return "完结 观看至 " + ani.episodeNum + " 话";
                } else if (ani.watchState === AniUtil.WATCH_STATE.WATCH_STATE_ABANDONED) {
                    return "已弃 观看至 " + ani.episodeNum + " 话";
                }
            } else if (ani.finState === AniUtil.FIN_STATE.FIN_STATE_UN_FIN) {
                if (ani.watchState === AniUtil.WATCH_STATE.WATCH_STATE_FINISH) {
                    return "观看至 " + ani.episodeNum + " 话";
                } else if (ani.watchState === AniUtil.WATCH_STATE.WATCH_STATE_BEFORE) {
                    return "尚未观看"
                } else if (ani.watchState === AniUtil.WATCH_STATE.WATCH_STATE_CHASING) {
                    return "观看至 " + ani.episodeNum + " 话";
                } else if (ani.watchState === AniUtil.WATCH_STATE.WATCH_STATE_ABANDONED) {
                    return "已弃 观看至 " + ani.episodeNum + " 话";
                }
            }
            return ani.episodeNum;
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
var markWatchState = function (state) {
    var _request = {
        id:app.currentFoucsRowId,
        watchState:state
    };
    AniUtil.modifyAni(_request,function(){
        queryByPage();
    },function(){
        alert("failed");
    });
};

var AniUtil = {};
AniUtil.addAni = function (ani, success, fail) {
    $.ajax({
        type: "post",
        url: "/anime/ani/addAni",
        data: ani,
        success: function (data) {
            success(data);
        },
        error: function () {

        }
    });
};

AniUtil.queryAniById = function (id, success, fail) {
    $.ajax({
        type: "post",
        url: "/anime/ani/queryAniById",
        data: "id=" + id,
        success: function (data) {
            success(data);
        },
        error: function () {
            fail();
        }
    });
};

AniUtil.queryAniByPage = function (request, success, fail) {
    $.ajax({
        type: "post",
        contentType: "application/json; charset=utf-8",
        url: "/anime/ani/queryAniByPage",
        data: JSON.stringify(request),
        success: function (data) {
            success(data);
        },
        error: function () {
            fail();
        }
    });
};

AniUtil.plusOne = function (id, success, fail) {
    $.ajax({
        type: "post",
        contentType: "application/json; charset=utf-8",
        url: "/anime/ani/plusOne",
        data: JSON.stringify({"id": id}),
        success: function (data) {
            success(data);
        },
        error: function () {
            fail();
        }
    });
};

AniUtil.modifyAni = function (ani, success, fail) {
    $.ajax({
        type: "post",
        contentType: "application/json; charset=utf-8",
        url: "/anime/ani/modifyAni",
        data: JSON.stringify(ani),
        success: function (data) {
            success(data);
        },
        error: function () {
            fail();
        }
    });
};

AniUtil.total = function (success, fail) {
    $.ajax({
        type: "post",
        contentType: "application/json; charset=utf-8",
        url: "/anime/ani/total",
        success: function (data) {
            success(data);
        },
        error: function () {
            fail();
        }
    });
};

AniUtil.FIN_STATE = {
    FIN_STATE_FIN: 1,
    FIN_STATE_UN_FIN: 0,
    FIN_STATE_COMING: 2
};

AniUtil.WATCH_STATE = {
    WATCH_STATE_BEFORE: 0,
    WATCH_STATE_CHASING: 1,
    WATCH_STATE_FINISH: 2
};
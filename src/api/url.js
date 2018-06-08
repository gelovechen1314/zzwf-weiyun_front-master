export const URL = {
    /**
     * 基础接口
     */
    SYSTEM_VERSION(api){ //版本检测 api:当前版本号
        return `/stu/system/version/?api=${api}`;
    },
    BIND_DEVICE: '/stu/bind/device/', //设备绑定
    TIME_SERVICE: '/stu/account/heartbeat/', //心跳
    WARNING(tid, mark){ //提交报警信息
        return `/stu/warning/?tid=${tid}&mark=${mark}`;
    },
    AWARD(r_type){  //提交抽奖结果，r_type 0:无奖励 1: 奖励5经验 2: 奖励5U币
        return `/stu/getreward/?r_type=${r_type}`;
    },

    /**
     * 登录接口
     */
    ACCOUNT_AUTH: '/stu/account/auth/', //登录

    /**
     * 首页接口
     */
    HOME: '/stu/index/',//首页
    HEAD_LIST: "/stu/head/list/",//头像列表
    SUBMIT_HEAD: '/stu/head/submit/',//头像提交
    U_COIN_PROPS: '/stu/coin/props/',//U币商城
    U_COIN_PROPS_SHOP: '/stu/coin/props/buy/',//U币商城-购买道具
    U_COIN_PROPS_TOOL: '/stu/coin/props/use/',//U币商城-使用道具
    JUMP(cid){ //请求临时课时
        return `/stu/jump/?cid=${cid}`;
    },
    JUMP_CHECK: '/stu/jump/check/', //检查临时课时    status:申请批改状态 0 未批改 1 已同意 2 已拒绝 -1 推送超时

    /**
     * 关卡列表接口
     */
    LEVEL(cid){ //关卡列表页
        return `/stu/level/?cid=${cid}`;
    },

    /**
     * 神秘关卡接口
     */
    MYSTIC_CORRECT: "/stu/test/mystic/correct/",//订正错题
    MYSTIC_CORRECT_SUBMIT: "/stu/test/mystic/correct/submit/",//订正错题提交
    MYSTIC_KNOWLEDGE: "/stu/test/mystic/knowledge/",//获取知识重温
    MYSTIC_KNOWLEDGE_SUBMIT: "/stu/test/mystic/knowledge/submit/",//知识重温提交

    /**
     * 第一关接口
     */
    KNOWLEDGE(tid){//获取知识列表
        return `/stu/test/knowledge/?tid=${tid}`;
    },
    KNOWLEDGE_VIEW_SUBMIT: '/stu/test/knowledge/view_submit/',//知识提交
    KNOWLEDGE_TEST(tid){//获取知识测试题
      return `/stu/test/knowledge/test/?tid=${tid}`;
    },
    KNOWLEDGE_TEST_SUBMIT: '/stu/test/knowledge/test_submit/',//知识测试提交
    KNOWLEDGE_WEAK(tid){//获取薄弱知识列表
      return `/stu/test/knowledge/weak/?tid=${tid}`;
    },
    KNOWLEDGE_CORRECT(tid){//获取错题订正试题
      return `stu/test/knowledge/correct/?tid=${tid}`;
    },
    KNOWLEDGE_CORRECT_SUBMIT:'/stu/test/knowledge/correct_submit/',//知识错题订正提交
    KNOWLEDGE_EVALUATE(tid){//获取知识学习评价
        return `/stu/test/knowledge/evaluate/?tid=${tid}`;
    },

    /**
     * 第二关接口
     */
    METHOD(tid){//获取方法数据
        return `/stu/test/method/?tid=${tid}`;
    },
    METHOD_VIEW_SUBMIT: '/stu/test/method/view_submit/',//方法提交
    METHOD_TEST(tid){//获取方法测试题
      return `/stu/test/method/test/?tid=${tid}`;
    },
    METHOD_TEST_SUBMIT: '/stu/test/method/test_submit/',//方法测试提交
    METHOD_WEAK(tid){//获取薄弱方法列表
        return `/stu/test/method/weak/?tid=${tid}`;
      },
    METHOD_CORRECT(tid){//获取错题订正试题
        return `stu/test/method/correct/?tid=${tid}`;
      },
    METHOD_CORRECT_SUBMIT:'/stu/test/method/correct_submit/',//方法错题订正提交
    METHOD_EVALUATE(tid){//获取方法学习评价
        return `/stu/test/method/evaluate/?tid=${tid}`;
    },

    /**
     * 第三、四关接口
     */
    QUESTION(tid, lid){//获取测试题
        return `/stu/test/question/?tid=${tid}&level_id=${lid}`;
    },
    QUESTION_SUBMIT: '/stu/test/question/submit/', //提交测试题
    QUESTION_EVALUATION(tid){//获取测试评价
        return `/stu/test/question/evaluate/?tid=${tid}`;
    },
    QUESTION_END_EVALUATION(tid, lid){//获取通关评价页
        return `/stu/test/question/end_evaluate/?tid=${tid}&level_id=${lid}`;
    },
    QUESTION_CORRECT(tid, lid){//获取错题订正题
        return `/stu/test/question/correct/?tid=${tid}&level_id=${lid}`;
    },
    QUESTION_CORRECT_SUBMIT: "/stu/test/question/correct/submit/",//提交错题订正
    QUESTION_SPECIFICATION(tid){//获取对比订正题
        return `/stu/test/question/specification/?tid=${tid}`;
    },
    QUESTION_SPECIFICATION_SUBMIT(tid){ //提交对比订正
        return `/stu/test/question/specification/submit/?tid=${tid}`;
    },
    QUESTION_SPECIFICATION_CHECK(tid){//获取对比订正批改结果
        return `/stu/test/question/specification/check/?tid=${tid}`;
    },
    QUESTION_STUDY(tid){//获取个性化学习
        return `/stu/test/question/study/?tid=${tid}`;
    },
    QUESTION_STUDY_SUBMIT(tid){//个性化学习提交
        return `/stu/test/question/study/submit/?tid=${tid}`;
    },

    /**
     * 章末测试接口
     */
    END_QUESTION(cid){//获取测试题
        return `/stu/test/unit_question/?cid=${cid}`;
    },
    END_QUESTION_SUBMIT: '/stu/test/unit_question/submit/', //提交测试题
    END_QUESTION_EVALUATION(cid){//获取测试评价
        return `/stu/test/unit_question/evaluate/?cid=${cid}`;
    },
    END_QUESTION_END_EVALUATION(cid){//获取通关评价页
        return `/stu/test/unit_question/end_evaluate/?cid=${cid}`;
    },
    END_QUESTION_CORRECT(cid){//获取错题订正题
        return `/stu/test/unit_question/correct/?cid=${cid}`;
    },
    END_QUESTION_CORRECT_SUBMIT: "/stu/test/unit_question/correct/submit/",//提交错题订正
    END_QUESTION_SPECIFICATION(cid){//获取对比订正题
        return `/stu/test/unit_question/specification/?cid=${cid}`;
    },
    END_QUESTION_SPECIFICATION_SUBMIT(cid){ //提交对比订正
        return `/stu/test/unit_question/specification/submit/?cid=${cid}`;
    },
    END_QUESTION_SPECIFICATION_CHECK(cid){//获取对比订正评价
        return `/stu/test/unit_question/specification/check/?cid=${cid}`;
    },
    END_QUESTION_STUDY(cid){//获取个性化学习
        return `/stu/test/unit_question/study/?cid=${cid}`;
    },
    END_QUESTION_STUDY_SUBMIT(cid){//个性化学习提交
        return `/stu/test/unit_question/study/submit/?cid=${cid}`;
    },
};

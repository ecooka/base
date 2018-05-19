package cn.ecook.basedemo.entity;

import java.util.List;

/**
 * @author ciba
 * @date 2018/4/3
 * @description
 */

public class Football {

    /**
     * reason : 查询成功
     * result : {"key":"法甲","tabs":{"saicheng1":"第37轮赛程","saicheng2":"第38轮赛程","saicheng3":null,"jifenbang":"积分榜","sheshoubang":"射手榜"},"views":{"saicheng1":[{"c1":"已结束","c2":"05-12周六","c3":"02:45","c4T1":"甘冈","c4T1URL":"","c4R":"3-3","c4T2":"马赛","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920891"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"亚眠","c4T1URL":"","c4R":"2-0","c4T2":"梅斯","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920888"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"昂热","c4T1URL":"","c4R":"0-2","c4T2":"南特","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920889"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"波尔多","c4T1URL":"","c4R":"4-2","c4T2":"图卢兹","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920890"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"里尔","c4T1URL":"","c4R":"2-1","c4T2":"第戎","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920892"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"摩纳哥","c4T1URL":"","c4R":"1-0","c4T2":"圣埃蒂安","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920893"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"蒙彼利埃","c4T1URL":"","c4R":"1-1","c4T2":"特鲁瓦","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920894"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"尼斯","c4T1URL":"","c4R":"4-1","c4T2":"卡昂","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920895"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"巴黎圣日耳曼","c4T1URL":"","c4R":"0-2","c4T2":"雷恩","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"全场战报","c52Link":"","liveid":"920896"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"斯特拉斯堡","c4T1URL":"","c4R":"3-2","c4T2":"里昂","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920897"}],"saicheng2":[{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"卡昂","c4T1URL":"","c4R":"VS","c4T2":"巴黎圣日耳曼","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920898"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"第戎","c4T1URL":"","c4R":"VS","c4T2":"昂热","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920899"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"里昂","c4T1URL":"","c4R":"VS","c4T2":"尼斯","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920900"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"马赛","c4T1URL":"","c4R":"VS","c4T2":"亚眠","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920901"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"梅斯","c4T1URL":"","c4R":"VS","c4T2":"波尔多","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920902"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"南特","c4T1URL":"","c4R":"VS","c4T2":"斯特拉斯堡","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920903"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"雷恩","c4T1URL":"","c4R":"VS","c4T2":"蒙彼利埃","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920904"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"圣埃蒂安","c4T1URL":"","c4R":"VS","c4T2":"里尔","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920905"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"图卢兹","c4T1URL":"","c4R":"VS","c4T2":"甘冈","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920906"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"特鲁瓦","c4T1URL":"","c4R":"VS","c4T2":"摩纳哥","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920907"}],"saicheng3":null,"jifenbang":[{"c1":"1","c2":"巴黎圣日耳曼","c2L":"","c3":"37","c41":"29","c42":"5","c43":"3","c5":"79","c6":"92"},{"c1":"2","c2":"摩纳哥","c2L":"","c3":"37","c41":"23","c42":"8","c43":"6","c5":"37","c6":"77"},{"c1":"3","c2":"里昂","c2L":"","c3":"37","c41":"22","c42":"9","c43":"6","c5":"43","c6":"75"},{"c1":"4","c2":"马赛","c2L":"","c3":"37","c41":"21","c42":"11","c43":"5","c5":"32","c6":"74"},{"c1":"5","c2":"雷恩","c2L":"","c3":"37","c41":"16","c42":"9","c43":"12","c5":"6","c6":"57"},{"c1":"6","c2":"尼斯","c2L":"","c3":"37","c41":"15","c42":"9","c43":"13","c5":"2","c6":"54"},{"c1":"7","c2":"波尔多","c2L":"","c3":"37","c41":"15","c42":"7","c43":"15","c5":"1","c6":"52"},{"c1":"8","c2":"圣埃蒂安","c2L":"","c3":"37","c41":"14","c42":"10","c43":"13","c5":"-8","c6":"52"},{"c1":"9","c2":"蒙彼利埃","c2L":"","c3":"37","c41":"11","c42":"17","c43":"9","c5":"3","c6":"50"},{"c1":"10","c2":"南特","c2L":"","c3":"37","c41":"13","c42":"10","c43":"14","c5":"-6","c6":"49"}],"sheshoubang":[{"c1":"1","c2":"卡瓦尼","c2L":"","c3":"巴黎圣日耳曼","c3L":"","c4":"28","c5":"3"},{"c1":"2","c2":"绍维恩","c2L":"","c3":"马赛","c3L":"","c4":"22","c5":"3"},{"c1":"3","c2":"内马尔","c2L":"","c3":"巴黎圣日耳曼","c3L":"","c4":"20","c5":"4"},{"c1":"4","c2":"法里亚诺","c2L":"","c3":"里昂","c3L":"","c4":"18","c5":"1"},{"c1":"5","c2":"米奎尔-洛佩斯","c2L":"","c3":"里昂","c3L":"","c4":"18","c5":"3"},{"c1":"6","c2":"法尔考","c2L":"","c3":"摩纳哥","c3L":"","c4":"18","c5":"3"},{"c1":"7","c2":"巴洛特利","c2L":"","c3":"尼斯","c3L":"","c4":"18","c5":"6"},{"c1":"8","c2":"埃坎比","c2L":"","c3":"昂热","c3L":"","c4":"17","c5":"3"},{"c1":"9","c2":"德帕伊","c2L":"","c3":"里昂","c3L":"","c4":"16","c5":"2"},{"c1":"10","c2":"罗克斯","c2L":"","c3":"梅斯","c3L":"","c4":"15","c5":"0"}]}}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * key : 法甲
         * tabs : {"saicheng1":"第37轮赛程","saicheng2":"第38轮赛程","saicheng3":null,"jifenbang":"积分榜","sheshoubang":"射手榜"}
         * views : {"saicheng1":[{"c1":"已结束","c2":"05-12周六","c3":"02:45","c4T1":"甘冈","c4T1URL":"","c4R":"3-3","c4T2":"马赛","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920891"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"亚眠","c4T1URL":"","c4R":"2-0","c4T2":"梅斯","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920888"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"昂热","c4T1URL":"","c4R":"0-2","c4T2":"南特","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920889"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"波尔多","c4T1URL":"","c4R":"4-2","c4T2":"图卢兹","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920890"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"里尔","c4T1URL":"","c4R":"2-1","c4T2":"第戎","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920892"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"摩纳哥","c4T1URL":"","c4R":"1-0","c4T2":"圣埃蒂安","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920893"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"蒙彼利埃","c4T1URL":"","c4R":"1-1","c4T2":"特鲁瓦","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920894"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"尼斯","c4T1URL":"","c4R":"4-1","c4T2":"卡昂","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920895"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"巴黎圣日耳曼","c4T1URL":"","c4R":"0-2","c4T2":"雷恩","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"全场战报","c52Link":"","liveid":"920896"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"斯特拉斯堡","c4T1URL":"","c4R":"3-2","c4T2":"里昂","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920897"}],"saicheng2":[{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"卡昂","c4T1URL":"","c4R":"VS","c4T2":"巴黎圣日耳曼","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920898"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"第戎","c4T1URL":"","c4R":"VS","c4T2":"昂热","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920899"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"里昂","c4T1URL":"","c4R":"VS","c4T2":"尼斯","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920900"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"马赛","c4T1URL":"","c4R":"VS","c4T2":"亚眠","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920901"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"梅斯","c4T1URL":"","c4R":"VS","c4T2":"波尔多","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920902"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"南特","c4T1URL":"","c4R":"VS","c4T2":"斯特拉斯堡","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920903"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"雷恩","c4T1URL":"","c4R":"VS","c4T2":"蒙彼利埃","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920904"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"圣埃蒂安","c4T1URL":"","c4R":"VS","c4T2":"里尔","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920905"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"图卢兹","c4T1URL":"","c4R":"VS","c4T2":"甘冈","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920906"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"特鲁瓦","c4T1URL":"","c4R":"VS","c4T2":"摩纳哥","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920907"}],"saicheng3":null,"jifenbang":[{"c1":"1","c2":"巴黎圣日耳曼","c2L":"","c3":"37","c41":"29","c42":"5","c43":"3","c5":"79","c6":"92"},{"c1":"2","c2":"摩纳哥","c2L":"","c3":"37","c41":"23","c42":"8","c43":"6","c5":"37","c6":"77"},{"c1":"3","c2":"里昂","c2L":"","c3":"37","c41":"22","c42":"9","c43":"6","c5":"43","c6":"75"},{"c1":"4","c2":"马赛","c2L":"","c3":"37","c41":"21","c42":"11","c43":"5","c5":"32","c6":"74"},{"c1":"5","c2":"雷恩","c2L":"","c3":"37","c41":"16","c42":"9","c43":"12","c5":"6","c6":"57"},{"c1":"6","c2":"尼斯","c2L":"","c3":"37","c41":"15","c42":"9","c43":"13","c5":"2","c6":"54"},{"c1":"7","c2":"波尔多","c2L":"","c3":"37","c41":"15","c42":"7","c43":"15","c5":"1","c6":"52"},{"c1":"8","c2":"圣埃蒂安","c2L":"","c3":"37","c41":"14","c42":"10","c43":"13","c5":"-8","c6":"52"},{"c1":"9","c2":"蒙彼利埃","c2L":"","c3":"37","c41":"11","c42":"17","c43":"9","c5":"3","c6":"50"},{"c1":"10","c2":"南特","c2L":"","c3":"37","c41":"13","c42":"10","c43":"14","c5":"-6","c6":"49"}],"sheshoubang":[{"c1":"1","c2":"卡瓦尼","c2L":"","c3":"巴黎圣日耳曼","c3L":"","c4":"28","c5":"3"},{"c1":"2","c2":"绍维恩","c2L":"","c3":"马赛","c3L":"","c4":"22","c5":"3"},{"c1":"3","c2":"内马尔","c2L":"","c3":"巴黎圣日耳曼","c3L":"","c4":"20","c5":"4"},{"c1":"4","c2":"法里亚诺","c2L":"","c3":"里昂","c3L":"","c4":"18","c5":"1"},{"c1":"5","c2":"米奎尔-洛佩斯","c2L":"","c3":"里昂","c3L":"","c4":"18","c5":"3"},{"c1":"6","c2":"法尔考","c2L":"","c3":"摩纳哥","c3L":"","c4":"18","c5":"3"},{"c1":"7","c2":"巴洛特利","c2L":"","c3":"尼斯","c3L":"","c4":"18","c5":"6"},{"c1":"8","c2":"埃坎比","c2L":"","c3":"昂热","c3L":"","c4":"17","c5":"3"},{"c1":"9","c2":"德帕伊","c2L":"","c3":"里昂","c3L":"","c4":"16","c5":"2"},{"c1":"10","c2":"罗克斯","c2L":"","c3":"梅斯","c3L":"","c4":"15","c5":"0"}]}
         */

        private String key;
        private TabsBean tabs;
        private ViewsBean views;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public TabsBean getTabs() {
            return tabs;
        }

        public void setTabs(TabsBean tabs) {
            this.tabs = tabs;
        }

        public ViewsBean getViews() {
            return views;
        }

        public void setViews(ViewsBean views) {
            this.views = views;
        }

        public static class TabsBean {
            /**
             * saicheng1 : 第37轮赛程
             * saicheng2 : 第38轮赛程
             * saicheng3 : null
             * jifenbang : 积分榜
             * sheshoubang : 射手榜
             */

            private String saicheng1;
            private String saicheng2;
            private Object saicheng3;
            private String jifenbang;
            private String sheshoubang;

            public String getSaicheng1() {
                return saicheng1;
            }

            public void setSaicheng1(String saicheng1) {
                this.saicheng1 = saicheng1;
            }

            public String getSaicheng2() {
                return saicheng2;
            }

            public void setSaicheng2(String saicheng2) {
                this.saicheng2 = saicheng2;
            }

            public Object getSaicheng3() {
                return saicheng3;
            }

            public void setSaicheng3(Object saicheng3) {
                this.saicheng3 = saicheng3;
            }

            public String getJifenbang() {
                return jifenbang;
            }

            public void setJifenbang(String jifenbang) {
                this.jifenbang = jifenbang;
            }

            public String getSheshoubang() {
                return sheshoubang;
            }

            public void setSheshoubang(String sheshoubang) {
                this.sheshoubang = sheshoubang;
            }
        }

        public static class ViewsBean {
            /**
             * saicheng1 : [{"c1":"已结束","c2":"05-12周六","c3":"02:45","c4T1":"甘冈","c4T1URL":"","c4R":"3-3","c4T2":"马赛","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920891"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"亚眠","c4T1URL":"","c4R":"2-0","c4T2":"梅斯","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920888"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"昂热","c4T1URL":"","c4R":"0-2","c4T2":"南特","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920889"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"波尔多","c4T1URL":"","c4R":"4-2","c4T2":"图卢兹","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920890"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"里尔","c4T1URL":"","c4R":"2-1","c4T2":"第戎","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920892"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"摩纳哥","c4T1URL":"","c4R":"1-0","c4T2":"圣埃蒂安","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920893"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"蒙彼利埃","c4T1URL":"","c4R":"1-1","c4T2":"特鲁瓦","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920894"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"尼斯","c4T1URL":"","c4R":"4-1","c4T2":"卡昂","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920895"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"巴黎圣日耳曼","c4T1URL":"","c4R":"0-2","c4T2":"雷恩","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"全场战报","c52Link":"","liveid":"920896"},{"c1":"已结束","c2":"05-13周日","c3":"03:00","c4T1":"斯特拉斯堡","c4T1URL":"","c4R":"3-2","c4T2":"里昂","c4T2URL":"","c51":"全场统计","c51Link":"","c52":"图文数据","c52Link":"","liveid":"920897"}]
             * saicheng2 : [{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"卡昂","c4T1URL":"","c4R":"VS","c4T2":"巴黎圣日耳曼","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920898"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"第戎","c4T1URL":"","c4R":"VS","c4T2":"昂热","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920899"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"里昂","c4T1URL":"","c4R":"VS","c4T2":"尼斯","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920900"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"马赛","c4T1URL":"","c4R":"VS","c4T2":"亚眠","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920901"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"梅斯","c4T1URL":"","c4R":"VS","c4T2":"波尔多","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920902"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"南特","c4T1URL":"","c4R":"VS","c4T2":"斯特拉斯堡","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920903"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"雷恩","c4T1URL":"","c4R":"VS","c4T2":"蒙彼利埃","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920904"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"圣埃蒂安","c4T1URL":"","c4R":"VS","c4T2":"里尔","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920905"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"图卢兹","c4T1URL":"","c4R":"VS","c4T2":"甘冈","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920906"},{"c1":"未开赛","c2":"05-20周日","c3":"03:00","c4T1":"特鲁瓦","c4T1URL":"","c4R":"VS","c4T2":"摩纳哥","c4T2URL":"","c51":"视频暂无","c51Link":"","c52":"前瞻预测","c52Link":"","liveid":"920907"}]
             * saicheng3 : null
             * jifenbang : [{"c1":"1","c2":"巴黎圣日耳曼","c2L":"","c3":"37","c41":"29","c42":"5","c43":"3","c5":"79","c6":"92"},{"c1":"2","c2":"摩纳哥","c2L":"","c3":"37","c41":"23","c42":"8","c43":"6","c5":"37","c6":"77"},{"c1":"3","c2":"里昂","c2L":"","c3":"37","c41":"22","c42":"9","c43":"6","c5":"43","c6":"75"},{"c1":"4","c2":"马赛","c2L":"","c3":"37","c41":"21","c42":"11","c43":"5","c5":"32","c6":"74"},{"c1":"5","c2":"雷恩","c2L":"","c3":"37","c41":"16","c42":"9","c43":"12","c5":"6","c6":"57"},{"c1":"6","c2":"尼斯","c2L":"","c3":"37","c41":"15","c42":"9","c43":"13","c5":"2","c6":"54"},{"c1":"7","c2":"波尔多","c2L":"","c3":"37","c41":"15","c42":"7","c43":"15","c5":"1","c6":"52"},{"c1":"8","c2":"圣埃蒂安","c2L":"","c3":"37","c41":"14","c42":"10","c43":"13","c5":"-8","c6":"52"},{"c1":"9","c2":"蒙彼利埃","c2L":"","c3":"37","c41":"11","c42":"17","c43":"9","c5":"3","c6":"50"},{"c1":"10","c2":"南特","c2L":"","c3":"37","c41":"13","c42":"10","c43":"14","c5":"-6","c6":"49"}]
             * sheshoubang : [{"c1":"1","c2":"卡瓦尼","c2L":"","c3":"巴黎圣日耳曼","c3L":"","c4":"28","c5":"3"},{"c1":"2","c2":"绍维恩","c2L":"","c3":"马赛","c3L":"","c4":"22","c5":"3"},{"c1":"3","c2":"内马尔","c2L":"","c3":"巴黎圣日耳曼","c3L":"","c4":"20","c5":"4"},{"c1":"4","c2":"法里亚诺","c2L":"","c3":"里昂","c3L":"","c4":"18","c5":"1"},{"c1":"5","c2":"米奎尔-洛佩斯","c2L":"","c3":"里昂","c3L":"","c4":"18","c5":"3"},{"c1":"6","c2":"法尔考","c2L":"","c3":"摩纳哥","c3L":"","c4":"18","c5":"3"},{"c1":"7","c2":"巴洛特利","c2L":"","c3":"尼斯","c3L":"","c4":"18","c5":"6"},{"c1":"8","c2":"埃坎比","c2L":"","c3":"昂热","c3L":"","c4":"17","c5":"3"},{"c1":"9","c2":"德帕伊","c2L":"","c3":"里昂","c3L":"","c4":"16","c5":"2"},{"c1":"10","c2":"罗克斯","c2L":"","c3":"梅斯","c3L":"","c4":"15","c5":"0"}]
             */

            private Object saicheng3;
            private List<Saicheng1Bean> saicheng1;
            private List<Saicheng2Bean> saicheng2;
            private List<JifenbangBean> jifenbang;
            private List<SheshoubangBean> sheshoubang;

            public Object getSaicheng3() {
                return saicheng3;
            }

            public void setSaicheng3(Object saicheng3) {
                this.saicheng3 = saicheng3;
            }

            public List<Saicheng1Bean> getSaicheng1() {
                return saicheng1;
            }

            public void setSaicheng1(List<Saicheng1Bean> saicheng1) {
                this.saicheng1 = saicheng1;
            }

            public List<Saicheng2Bean> getSaicheng2() {
                return saicheng2;
            }

            public void setSaicheng2(List<Saicheng2Bean> saicheng2) {
                this.saicheng2 = saicheng2;
            }

            public List<JifenbangBean> getJifenbang() {
                return jifenbang;
            }

            public void setJifenbang(List<JifenbangBean> jifenbang) {
                this.jifenbang = jifenbang;
            }

            public List<SheshoubangBean> getSheshoubang() {
                return sheshoubang;
            }

            public void setSheshoubang(List<SheshoubangBean> sheshoubang) {
                this.sheshoubang = sheshoubang;
            }

            public static class Saicheng1Bean {
                /**
                 * c1 : 已结束
                 * c2 : 05-12周六
                 * c3 : 02:45
                 * c4T1 : 甘冈
                 * c4T1URL :
                 * c4R : 3-3
                 * c4T2 : 马赛
                 * c4T2URL :
                 * c51 : 全场统计
                 * c51Link :
                 * c52 : 图文数据
                 * c52Link :
                 * liveid : 920891
                 */

                private String c1;
                private String c2;
                private String c3;
                private String c4T1;
                private String c4T1URL;
                private String c4R;
                private String c4T2;
                private String c4T2URL;
                private String c51;
                private String c51Link;
                private String c52;
                private String c52Link;
                private String liveid;

                public String getC1() {
                    return c1;
                }

                public void setC1(String c1) {
                    this.c1 = c1;
                }

                public String getC2() {
                    return c2;
                }

                public void setC2(String c2) {
                    this.c2 = c2;
                }

                public String getC3() {
                    return c3;
                }

                public void setC3(String c3) {
                    this.c3 = c3;
                }

                public String getC4T1() {
                    return c4T1;
                }

                public void setC4T1(String c4T1) {
                    this.c4T1 = c4T1;
                }

                public String getC4T1URL() {
                    return c4T1URL;
                }

                public void setC4T1URL(String c4T1URL) {
                    this.c4T1URL = c4T1URL;
                }

                public String getC4R() {
                    return c4R;
                }

                public void setC4R(String c4R) {
                    this.c4R = c4R;
                }

                public String getC4T2() {
                    return c4T2;
                }

                public void setC4T2(String c4T2) {
                    this.c4T2 = c4T2;
                }

                public String getC4T2URL() {
                    return c4T2URL;
                }

                public void setC4T2URL(String c4T2URL) {
                    this.c4T2URL = c4T2URL;
                }

                public String getC51() {
                    return c51;
                }

                public void setC51(String c51) {
                    this.c51 = c51;
                }

                public String getC51Link() {
                    return c51Link;
                }

                public void setC51Link(String c51Link) {
                    this.c51Link = c51Link;
                }

                public String getC52() {
                    return c52;
                }

                public void setC52(String c52) {
                    this.c52 = c52;
                }

                public String getC52Link() {
                    return c52Link;
                }

                public void setC52Link(String c52Link) {
                    this.c52Link = c52Link;
                }

                public String getLiveid() {
                    return liveid;
                }

                public void setLiveid(String liveid) {
                    this.liveid = liveid;
                }
            }

            public static class Saicheng2Bean {
                /**
                 * c1 : 未开赛
                 * c2 : 05-20周日
                 * c3 : 03:00
                 * c4T1 : 卡昂
                 * c4T1URL :
                 * c4R : VS
                 * c4T2 : 巴黎圣日耳曼
                 * c4T2URL :
                 * c51 : 视频暂无
                 * c51Link :
                 * c52 : 前瞻预测
                 * c52Link :
                 * liveid : 920898
                 */

                private String c1;
                private String c2;
                private String c3;
                private String c4T1;
                private String c4T1URL;
                private String c4R;
                private String c4T2;
                private String c4T2URL;
                private String c51;
                private String c51Link;
                private String c52;
                private String c52Link;
                private String liveid;

                public String getC1() {
                    return c1;
                }

                public void setC1(String c1) {
                    this.c1 = c1;
                }

                public String getC2() {
                    return c2;
                }

                public void setC2(String c2) {
                    this.c2 = c2;
                }

                public String getC3() {
                    return c3;
                }

                public void setC3(String c3) {
                    this.c3 = c3;
                }

                public String getC4T1() {
                    return c4T1;
                }

                public void setC4T1(String c4T1) {
                    this.c4T1 = c4T1;
                }

                public String getC4T1URL() {
                    return c4T1URL;
                }

                public void setC4T1URL(String c4T1URL) {
                    this.c4T1URL = c4T1URL;
                }

                public String getC4R() {
                    return c4R;
                }

                public void setC4R(String c4R) {
                    this.c4R = c4R;
                }

                public String getC4T2() {
                    return c4T2;
                }

                public void setC4T2(String c4T2) {
                    this.c4T2 = c4T2;
                }

                public String getC4T2URL() {
                    return c4T2URL;
                }

                public void setC4T2URL(String c4T2URL) {
                    this.c4T2URL = c4T2URL;
                }

                public String getC51() {
                    return c51;
                }

                public void setC51(String c51) {
                    this.c51 = c51;
                }

                public String getC51Link() {
                    return c51Link;
                }

                public void setC51Link(String c51Link) {
                    this.c51Link = c51Link;
                }

                public String getC52() {
                    return c52;
                }

                public void setC52(String c52) {
                    this.c52 = c52;
                }

                public String getC52Link() {
                    return c52Link;
                }

                public void setC52Link(String c52Link) {
                    this.c52Link = c52Link;
                }

                public String getLiveid() {
                    return liveid;
                }

                public void setLiveid(String liveid) {
                    this.liveid = liveid;
                }
            }

            public static class JifenbangBean {
                /**
                 * c1 : 1
                 * c2 : 巴黎圣日耳曼
                 * c2L :
                 * c3 : 37
                 * c41 : 29
                 * c42 : 5
                 * c43 : 3
                 * c5 : 79
                 * c6 : 92
                 */

                private String c1;
                private String c2;
                private String c2L;
                private String c3;
                private String c41;
                private String c42;
                private String c43;
                private String c5;
                private String c6;

                public String getC1() {
                    return c1;
                }

                public void setC1(String c1) {
                    this.c1 = c1;
                }

                public String getC2() {
                    return c2;
                }

                public void setC2(String c2) {
                    this.c2 = c2;
                }

                public String getC2L() {
                    return c2L;
                }

                public void setC2L(String c2L) {
                    this.c2L = c2L;
                }

                public String getC3() {
                    return c3;
                }

                public void setC3(String c3) {
                    this.c3 = c3;
                }

                public String getC41() {
                    return c41;
                }

                public void setC41(String c41) {
                    this.c41 = c41;
                }

                public String getC42() {
                    return c42;
                }

                public void setC42(String c42) {
                    this.c42 = c42;
                }

                public String getC43() {
                    return c43;
                }

                public void setC43(String c43) {
                    this.c43 = c43;
                }

                public String getC5() {
                    return c5;
                }

                public void setC5(String c5) {
                    this.c5 = c5;
                }

                public String getC6() {
                    return c6;
                }

                public void setC6(String c6) {
                    this.c6 = c6;
                }
            }

            public static class SheshoubangBean {
                /**
                 * c1 : 1
                 * c2 : 卡瓦尼
                 * c2L :
                 * c3 : 巴黎圣日耳曼
                 * c3L :
                 * c4 : 28
                 * c5 : 3
                 */

                private String c1;
                private String c2;
                private String c2L;
                private String c3;
                private String c3L;
                private String c4;
                private String c5;

                public String getC1() {
                    return c1;
                }

                public void setC1(String c1) {
                    this.c1 = c1;
                }

                public String getC2() {
                    return c2;
                }

                public void setC2(String c2) {
                    this.c2 = c2;
                }

                public String getC2L() {
                    return c2L;
                }

                public void setC2L(String c2L) {
                    this.c2L = c2L;
                }

                public String getC3() {
                    return c3;
                }

                public void setC3(String c3) {
                    this.c3 = c3;
                }

                public String getC3L() {
                    return c3L;
                }

                public void setC3L(String c3L) {
                    this.c3L = c3L;
                }

                public String getC4() {
                    return c4;
                }

                public void setC4(String c4) {
                    this.c4 = c4;
                }

                public String getC5() {
                    return c5;
                }

                public void setC5(String c5) {
                    this.c5 = c5;
                }
            }
        }
    }
}

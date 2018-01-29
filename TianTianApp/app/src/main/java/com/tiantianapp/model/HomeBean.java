package com.tiantianapp.model;

import com.tiantianapp.rxjava.BasicResponse;

import java.util.List;

/**
 * Created by Administrator on 2018/1/2 0002.
 */

public class HomeBean extends BasicResponse{
    private ResultBean result;
    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"9c36afcff35584634418112fe8732eb0","title":"元旦谁抢的中国游客多？日本韩国，一个笑了一个哭了","date":"2018-01-02 10:46","category":"头条","author_name":"中国之声","url":"http://mini.eastday.com/mobile/180102104658911.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180102/20180102104658_cf432890c1d0f2cc36e3e9cd94d7fbf5_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20180102/20180102104658_cf432890c1d0f2cc36e3e9cd94d7fbf5_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20180102/20180102104658_cf432890c1d0f2cc36e3e9cd94d7fbf5_4_mwpm_03200403.jpg"},{"uniquekey":"753fd2aaddfc72b0843b624578dd18fc","title":"外交部：法国总统马克龙将于1月8日至10日访华","date":"2018-01-02 10:49","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102104957474.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180102/20180102104957_83ed4ce173c61b27c6c57ac96b13049a_1_mwpm_03200403.jpg"},{"uniquekey":"50f8d9012d716834f3f03b72a96c573c","title":"蔡英文诡计被识破：她就是怕大陆对台\u201c斩首\u201d想逃跑","date":"2018-01-02 10:39","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102103946445.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102103946_5d5d7d0debdf0130573cdc425bf941c7_1_mwpm_03200403.jpg"},{"uniquekey":"daef476ce0224db68c11fde487be85ac","title":"加拿大遭遇最寒冷跨年夜 动物园紧急更换企鹅住所","date":"2018-01-02 10:39","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102103946244.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20180102/20180102103946_6dad24323495c94b0abb363fe5a7eab9_1_mwpm_03200403.jpg"},{"uniquekey":"5666908c809ec2b4a8a177678c87afed","title":"澳大利亚数百万只袋鼠神秘死亡 或感染疾病所致","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101921738.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180102/20180102101921_f9156641fc820d2b8187e4a6f52f04e0_1_mwpm_03200403.jpg"},{"uniquekey":"bf7173ff9938355611704c2c5193ed4e","title":"新年伊始 法国巴黎大区公交建设发布新\u201c路线图\u201d","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101921022.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102101921_d20c239f054ee53a1b0e3ce8fcc37d1d_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102101921_d20c239f054ee53a1b0e3ce8fcc37d1d_2_mwpm_03200403.jpg"},{"uniquekey":"0ee34f10926180b6f6e67175e57c10d8","title":"伦敦举行2018新年街头游行 美女街头载歌载舞","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101920933.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_10_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180102/20180102101920_0b43bdad201e8ba10e199ec7256cdb39_7_mwpm_03200403.jpg"},{"uniquekey":"403c87c50687233c6b1fa1b151e6e65c","title":"鲁哈尼呼吁冷静未奏效 伊朗周一继续爆发示威游行","date":"2018-01-02 10:19","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102101920422.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180102/20180102101920_a6b2f9fd5de7caea70aa073c5c1e3ac3_1_mwpm_03200403.jpg"},{"uniquekey":"884cddc3d795a65f696b1adc72b9f6c1","title":"此国核弹数量比中国还少，却敢对抗几十个国家，连美国都感到害怕","date":"2018-01-02 10:12","category":"头条","author_name":"星语星愿","url":"http://mini.eastday.com/mobile/180102101245416.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102_a92161d8105284e49d045a4b56952098_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102_16f09a7c9a89f0c6fc4d3cb30aeb453c_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180102/20180102_120f99deab8e7e088cc06f904c5cb945_cover_mwpm_03200403.jpg"},{"uniquekey":"b3dbce58c76fc397876d1e37e19f6f16","title":"上海首条BRT长啥样？和地铁一样快吗？","date":"2018-01-02 10:01","category":"头条","author_name":"第一地产","url":"http://mini.eastday.com/mobile/180102100115953.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102100115_57c12d6f1fea406b70575559471c928f_21_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102100115_57c12d6f1fea406b70575559471c928f_24_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180102/20180102100115_57c12d6f1fea406b70575559471c928f_19_mwpm_03200403.jpg"},{"uniquekey":"40ef7352733b53519b15ec0e228e8d83","title":"全球各国庆祝2018年新年","date":"2018-01-02 09:59","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/180102095951809.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20180102/20180102095951_a5f87039d92567cc1da4dcc0bb3aa028_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://04.imgmini.eastday.com/mobile/20180102/20180102095951_3b346381d6016b0125f1d23bbc9a7a9a_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20180102/20180102095951_b3e09a0048b418bc7c443eb81c181302_4_mwpm_03200403.jpg"},{"uniquekey":"f516ce4d78316cd5ab40d9d79d34578a","title":"广东今日气温回升晴好天气持续，但早晚仍较冷","date":"2018-01-02 09:59","category":"头条","author_name":"南方网","url":"http://mini.eastday.com/mobile/180102095906139.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180102/20180102095906_0c7c1b8f9285301f2c8e94383f327a3f_1_mwpm_03200403.jpg"},{"uniquekey":"242b8694f113b706382f76ddf92aa4d9","title":"韩国总统文在寅赴显忠院参拜为新年祈愿","date":"2018-01-02 09:58","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102095844158.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102095844_5b64d1c3e375d8e374c7c614010318ef_1_mwpm_03200403.jpg"},{"uniquekey":"d3cf82247fa8751b08372506d3079866","title":"你的训练计划合理吗？来看看那高手们的训练计划","date":"2018-01-02 09:51","category":"头条","author_name":"由恒健身","url":"http://mini.eastday.com/mobile/180102095102212.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102_484ae935507d6a95da5477bacf37af85_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102_13051d701a35f8aa36421b13c5d1e3ae_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180102/20180102_dd9712789bfc163275e2eb7f86640240_cover_mwpm_03200403.jpg"},{"uniquekey":"77432f09064b462989bdcff483ce0062","title":"2018上海落户政策，满足这些就可以轻松落户啦！","date":"2018-01-02 09:50","category":"头条","author_name":"上海本地宝","url":"http://mini.eastday.com/mobile/180102095008444.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102095008_66174ef95ac0c75bdec636de8c5423c7_1_mwpm_03200403.jpg"},{"uniquekey":"a3843f2a9cc2e0efe022034126ef7bef","title":"伊朗爆发抗议游行，不能一味地归咎于外部因素","date":"2018-01-02 09:48","category":"头条","author_name":"观察者网","url":"http://mini.eastday.com/mobile/180102094851757.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20180102/20180102094851_264caed8878da6fedd41ab8d1f5b9355_1_mwpm_03200403.jpg"},{"uniquekey":"3098ad5efeaaa1df5cc5523c56c514f9","title":"文汇战略 | 特朗普鲁哈尼隔空互怼，西方推波助澜，伊朗持续示威会演变成\u201c颜色革命\u201d吗？","date":"2018-01-02 09:46","category":"头条","author_name":"文汇网","url":"http://mini.eastday.com/mobile/180102094633046.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180102/20180102094633_7d4adaa88ee9480bc6ae99e553a4ecfd_1_mwpm_03200403.jpg"},{"uniquekey":"09978c0ed06ac06b51dbc1970e7cb77d","title":"瑞士新《收养法》生效 同性恋获许收养继子","date":"2018-01-02 09:37","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102093759535.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180102/20180102093759_b5783b0330ab6adf1e9205ec07730b40_1_mwpm_03200403.jpg"},{"uniquekey":"ff4a2c823710b149309a5f85d16a56fc","title":"刚刚，朝鲜放新年第一炮：核按钮随时启动！","date":"2018-01-02 09:32","category":"头条","author_name":"第一军情","url":"http://mini.eastday.com/mobile/180102093259571.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180102/20180102_0621c40d290c232889daf07dadd5fbcf_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20180102/20180102_e7f2755fb3ab85964af27192bd14eb0b_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20180102/20180102_91b0bb634a786c1dabaf63a69278fad3_cover_mwpm_03200403.jpg"},{"uniquekey":"c3ec57aeda58b519c3deab6a7192681b","title":"无人机之旅|2017爱上湖北的航拍在这儿","date":"2018-01-02 09:29","category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/180102092957459.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102092957_f1cc1f8bc7107fdf0e61cf2c3068dfd6_8_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102092957_450b0a76919b96767ba28008dbe097f8_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102092957_9433f5f4a95cfb531f7e881ab012111b_10_mwpm_03200403.jpg"},{"uniquekey":"d6d40cdd501084c7f010fadd8a26ec21","title":"好莱坞数百位大咖女性发声 关注劳工职场骚扰","date":"2018-01-02 09:27","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102092742696.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20180102/20180102092742_10a100d78ec9b80fb1785dfd009adf45_1_mwpm_03200403.jpg"},{"uniquekey":"55f83a76f04d57070a74c2ff374891cd","title":"法国财长：法国有意建立从欧洲经莫斯科到北京的\u201c商路\u201d","date":"2018-01-02 09:17","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102091727777.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102091727_05df455fc4656a61c72757670307b434_1_mwpm_03200403.jpg"},{"uniquekey":"4022be0e1b4ed90ee8aa0adeb1df9731","title":"祖母留下的破毛毯卖到975万！他瞬间成富翁，亲戚却不干了","date":"2018-01-02 09:16","category":"头条","author_name":"看什么鬼","url":"http://mini.eastday.com/mobile/180102091602401.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102_4e15682d81a333e35f5e268442c7c315_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102_968e8dc4683b4f72c93f8fd3e041a08a_cover_mwpm_03200403.jpg"},{"uniquekey":"adf3be7efda4786adb1c1f12b7031fa4","title":"大儿子再度被曝出轨带妹开房，洪金宝听后双眼犀利发飙怒斥记者！","date":"2018-01-02 09:10","category":"头条","author_name":"刘艺侨Joe","url":"http://mini.eastday.com/mobile/180102091021617.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180102/20180102_032fba8ac4999b18a9a2216e86cb45b8_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20180102/20180102_b21350f23a0323c5fe6f8201df97df33_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20180102/20180102_91dc9f69c74da06035290b1a665985f7_cover_mwpm_03200403.jpg"},{"uniquekey":"bcfb32a9dbfb596ae7d7e142ea2c9a44","title":"日媒：这两个原因让中国迅速超过日本","date":"2018-01-02 09:05","category":"头条","author_name":"观察者网","url":"http://mini.eastday.com/mobile/180102090501799.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20180102/20180102090501_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg"},{"uniquekey":"33a5a6d9bb3a7f5968a55983dc05ccc6","title":"朝鲜释放善意，就看美国如何接招，如果一意孤行，将失去道义！","date":"2018-01-02 09:04","category":"头条","author_name":"第一军情","url":"http://mini.eastday.com/mobile/180102090442044.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20180102/20180102_ab3ab2f2f5f1ffd3912efdc9bf49eeb7_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20180102/20180102_de4a8ab8928c9878abbf9d5f816892d2_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20180102/20180102_770b40b40a40fa119974c83c988316ce_cover_mwpm_03200403.jpg"},{"uniquekey":"7e48395cb5aeab9128cf373e72646579","title":"菲利普亲王又失言 笑称\u201c大胡子男为恐怖分子\u201d","date":"2018-01-02 08:56","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/180102085650210.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20180102/20180102085650_178d083b484f1ca24d7630be8fa7b00c_1_mwpm_03200403.jpg"},{"uniquekey":"e86ccf3fae8f6769a0b45082a0934cd1","title":"上海垃圾偷倒太湖的背后，是特大城市的\u201c垃圾围城\u201d","date":"2018-01-02 08:55","category":"头条","author_name":"凤凰社会","url":"http://mini.eastday.com/mobile/180102085550191.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20180102/20180102085550_2f049b230745990f71e04e937d25da29_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://07.imgmini.eastday.com/mobile/20180102/20180102085550_2f049b230745990f71e04e937d25da29_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20180102/20180102085550_2f049b230745990f71e04e937d25da29_2_mwpm_03200403.jpg"},{"uniquekey":"e7db134f614b78b1906bf2ef1640d412","title":"未婚夫妇拍摄订婚照片，当新娘旋转一圈后，出现这样尴尬的一幕！","date":"2018-01-02 08:51","category":"头条","author_name":"涛总说车","url":"http://mini.eastday.com/mobile/180102085142010.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20180102/20180102_4d55fc079c5a1e4d149a8cd13c942d32_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20180102/20180102_ff7f603c32eea9e15976c0e09ca737c0_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20180102/20180102_77127a2e80c4d70f0bc9ae555524a350_cover_mwpm_03200403.jpg"},{"uniquekey":"b374dff81f37aae3e98f54631e9d5652","title":"70岁三婚嫁25岁小伙，这个女人活出了全世界女人想要的样子","date":"2018-01-02 08:47","category":"头条","author_name":"经常阅读","url":"http://mini.eastday.com/mobile/180102084729487.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20180102/20180102_150fb43773fab096782e55b72482c313_cover_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20180102/20180102_2c7c9e6159d4e0dfa46c64016109efdd_cover_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20180102/20180102_75f469a9295fea9570f5e612356ea02c_cover_mwpm_03200403.jpg"}]
         */

        private String stat;
        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uniquekey : 9c36afcff35584634418112fe8732eb0
             * title : 元旦谁抢的中国游客多？日本韩国，一个笑了一个哭了
             * date : 2018-01-02 10:46
             * category : 头条
             * author_name : 中国之声
             * url : http://mini.eastday.com/mobile/180102104658911.html
             * thumbnail_pic_s : http://00.imgmini.eastday.com/mobile/20180102/20180102104658_cf432890c1d0f2cc36e3e9cd94d7fbf5_1_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://00.imgmini.eastday.com/mobile/20180102/20180102104658_cf432890c1d0f2cc36e3e9cd94d7fbf5_3_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://00.imgmini.eastday.com/mobile/20180102/20180102104658_cf432890c1d0f2cc36e3e9cd94d7fbf5_4_mwpm_03200403.jpg
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }
}

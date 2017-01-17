var vue = new Vue({
        el: '#app',
        mounted: function () {
            const dom = document.getElementById("detail");
            this.chart = echarts.init(dom);
            this.getRedisInfo();
            //this.showDetail();
        },

        data: {
            clusterData: [],
            nodeData: [],
            clusterShow: true,
            nodeShow: true,
            detailShow: false,
            detailInfo: [],
            chartOption: {
                colors: ['#5793f3', '#d14a61', '#675bba'],
                tooltip: {
                    trigger: 'axis'
                },

                legend: {
                    data: ['used_memory', 'rss', 'peak']
                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        data: []
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value} M'
                        }
                    }
                ],
                series: [
                    {
                        name: 'used_memory',
                        type: 'line',
                        data: []
                    },
                    {
                        name: 'rss',
                        type: 'line',
                        data: []
                    },
                    {
                        name: 'peak',
                        type: 'line',
                        data: []
                    }
                ]
            },
            visible: false
        },
        methods: {
            getRedisInfo: function () {
                $.getJSON('/infos', function (ret) {
                        let clusterInfo = [];
                        clusterInfo.push(ret.clusterInfo);
                        this.clusterData = clusterInfo;
                        this.nodeData = ret.nodesInfo;
                    }.bind(this)
                );
            }
            ,
            getNodeDetail: function (id) {
                $.getJSON('/nodes', {id: id, count: 100}, function (ret) {
                        //TODO
               //         this.nodeShow = false;
                        this.detailShow = true;
                        this.detailInfo = ret;
                        this.showDetail(ret);
                    }.bind(this)
                );
            }
            ,
            prepareDetailInfo: function (ret) {

                var used=[];
                var rss=[];
                var peak=[];
                var time=[];
                ret.forEach(item => {
                    time.push(item.time.substr(10,6));
                    var info=JSON.parse(item.info);
                    used.push((info.used_memory/1048576).toFixed(2));
                    peak.push((info.used_memory_peak/1048576).toFixed(2));
                    rss.push((info.used_memory_rss/1048576).toFixed(2));
                });
                this.chartOption.xAxis[0].data=time;
                this.chartOption.series[0].data=used;//used_memory
                this.chartOption.series[1].data=rss;//rss
                this.chartOption.series[2].data=peak;//peak

            },
            showDetail: function (ret) {
                this.prepareDetailInfo(ret);
                this.chart.setOption(this.chartOption);
            }
        }
    })
    ;
setInterval(vue.getRedisInfo, 5000);
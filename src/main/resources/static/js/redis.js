var vue=new Vue({
    el: '#app',
    mounted: function () {
       this.getRedisInfo();
    },

    data: {
        clusterData: [],
        nodeData: [],
        visible: false
    },
    methods: {
        getRedisInfo: function(){
            $.getJSON('/infos', function (ret) {
                let clusterInfo=[];
                clusterInfo.push(ret.clusterInfo);
                this.clusterData=clusterInfo;
                this.nodeData=ret.nodesInfo;
                }.bind(this)
            );
        },
        getNodeDetail: function (id) {
            $.getJSON('/nodes?id='+id, function (ret) {
                    //TODO
                console.log(id);
                }
            );
        }
    }
});
setInterval(vue.getRedisInfo,5000);
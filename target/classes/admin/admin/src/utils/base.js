const base = {
    get() {
        return {
            url : "http://localhost:8080/gaoxiaoxueshengshixiguanlixitong/",
            name: "gaoxiaoxueshengshixiguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gaoxiaoxueshengshixiguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "高校实习管理系统"
        } 
    }
}
export default base

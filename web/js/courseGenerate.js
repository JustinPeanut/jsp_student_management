function generate(list,who,name,type,flag){
    // 展示内容

    $("tbody").empty();
    console.log(flag)
    for(let i = 0 ; i < list.length ; i++){
        let str = "<tr>\n" +
            "    <td>"+ (i+1) +"</td>\n" +
            "    <td>"+ list[i].courseName +"</td>\n" +
            "    <td> "+ list[i].classRoom +"</td>\n" +
            "    <td>"+ list[i].classTime +"</td>\n" +
            "    <td>\n" +
            "        <button type=\"button\" class=\"delete btn-xs btn-"+type+"\"><a href='" + flag + "Course?courseId="+ list[i].courseId +"'>"+name+"<a></button>\n" +
            "    </td>\n" +
            "</tr>"
        $(who).append(str);
    }
}
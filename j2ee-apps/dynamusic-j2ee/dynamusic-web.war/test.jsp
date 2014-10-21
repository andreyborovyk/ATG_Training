<%@ taglib uri="/dspTaglib" prefix="dsp" %>
<dsp:page>
<html>
<head>
<title>DSBtest</title>
</head>
<body>
<h1>DSB Test </h1>
<p>From a java object:
<dsp:droplet name="/dynamusic/CustomDroplet">
<dsp:param name="name" value="atg-tips"/>
<dsp:oparam name="output">
          Name is : <dsp:valueof param="myName"></dsp:valueof><br>
</dsp:oparam>
<dsp:oparam name="output1">
          Project is : <dsp:valueof param="project"></dsp:valueof><br>
</dsp:oparam>
<dsp:oparam name="output2">
          Module is : <dsp:valueof param="module"></dsp:valueof><br>
</dsp:oparam>
</dsp:droplet>
</body>
</html>
</dsp:page>
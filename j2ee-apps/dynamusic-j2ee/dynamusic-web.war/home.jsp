<%@ taglib uri="/dspTaglib" prefix="dsp" %>
<dsp:page>
<dsp:importbean bean="/atg/userprofiling/Profile"/>
<dsp:importbean bean="/dynamusic/FeaturedSongs"/>

<!-------------------------------------------------------------
  Dynamusic Site             DAF Site Mockup
  
  HOME
  
  Central page for the site; landing point following login, 
  providing starting point for site's pages.
  
  Version 4 - adds slot to advertise concerts for viewed 
              artists.
  
  ------------------------------------------------------------->
  

<HTML>
  <HEAD>
    <TITLE>Dynamusic Home</TITLE>
  </HEAD>
  <BODY>
    <!-- (replace this entire section by dynamically including 
          common/header.jsp) -->
    <dsp:include page="common/header.jsp">
       <dsp:param name="pagename" value="Home Page"/>
    </dsp:include>
    <!-- (end header banner) -->
    

    <table width="700" cellpadding="8">
      <tr>

        <!-- Sidebar -->

          <td width="100" bgcolor="ghostwhite" valign="top">
          <!-- (replace contents of this table cell by 
                dynamically including common/sidebar.html) -->
            <dsp:include page="common/sidebar.jsp"></dsp:include>        
          <!-- end sidebar -->
        </td>

        
        <!-- Page Body -->
        <td valign="top">
          <font face="Verdana,Geneva,Arial" size="-1">
          
          <!-- *** Start page content *** -->
          
            <table width="560">
              <tr>
                <td>

                <dsp:droplet name="/atg/dynamo/droplet/Switch">
                  <dsp:param bean="Profile.transient" name="value"/>
                  <dsp:oparam name="true">
                     Welcome to Dynamusic.  <a href="newProfile.jsp">Click here</a> to register. <p>
                  </dsp:oparam>
                  <dsp:oparam name="false">
                    <p>Welcome, <dsp:valueof bean="Profile.firstName"/><p>
                  </dsp:oparam>
                </dsp:droplet>
                  
                  This week's featured songs are:

                  <dsp:droplet name="/atg/dynamo/droplet/ForEach">
                    <dsp:param bean="FeaturedSongs.songs" name="array"/>
                    <dsp:oparam name="outputStart">
                      <ul>
                    </dsp:oparam>
                    <dsp:oparam name="outputEnd">
                      </ul>
                    </dsp:oparam>
                    <dsp:oparam name="output">
                      <li><dsp:valueof param="element"/>
                  
                    </dsp:oparam>
                    <dsp:oparam name="empty">
                      No featured songs this week.
                    </dsp:oparam>
                  </dsp:droplet>

                </td>
                <td width="160" align="center">
                  Featured Album:<br>
                  <a href="albumDetails.html"><img src="images/FieldsAndStreams.jpg"><br>
                    <b>Fields and Streams</b> - Fiona McFlorick
                  </a>
                </td>
              </tr>
              <tr><td height="80">&nbsp;</td><td></td></tr>
              <tr>
                <td valign="top">
                  Playing at a venue near you... <p>
                  <ul>
                    <li> 22 May 2011 - <a href="concertDetails.html">Autumn Winters at the Boston Concert Hall</a>
                    <li> 18 October 2011 - <a href="concertDetails.html">Charlie Grassfield at the Moncton Opera House</a>
                    <li> 14 June 2011 - <a href="concertDetails.html">Frida Jetsen at Jefferson Hall</a>
                  </ul>
                </td>
              </tr>
            </table>
            
          <!-- *** End real content *** -->
          
          </font>
        </td>
      </tr>
    </table>
  </BODY>
</HTML>
</dsp:page>

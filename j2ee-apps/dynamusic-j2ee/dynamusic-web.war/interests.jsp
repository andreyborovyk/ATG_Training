<%@ taglib uri="/dspTaglib" prefix="dsp"%>
<dsp:page>
	<dsp:importbean bean="/atg/userprofiling/Profile" />
	<dsp:importbean bean="/dynamusic/FeaturedSongs" />
	<dsp:importbean bean="/dynamusic/InterestsFormHandler" />
	<dsp:importbean bean="/dynamusic/FilterInterestsDropdownDroplet" />

	<HTML>
	<HEAD>
	<TITLE>Dynamusic Interests</TITLE>
	</HEAD>
	<BODY>
	<!-- (replace this entire section by dynamically including 
          common/header.jsp) -->
	<dsp:include page="common/header.jsp">
		<dsp:param name="pagename" value="Interests" />
	</dsp:include>
	<!-- (end header banner) -->


	<table width="700" cellpadding="8">
		<tr>

			<!-- Sidebar -->

			<td width="100" bgcolor="ghostwhite" valign="top"><!-- (replace contents of this table cell by 
                dynamically including common/sidebar.html) --> <dsp:include
				page="common/sidebar.jsp"></dsp:include> <!-- end sidebar --></td>


			<!-- Page Body -->
			<td valign="top"><font face="Verdana,Geneva,Arial" size="-1">

			<!-- *** Start page content *** -->

			<table width="560">
				<tr>
					<td>
					<!--filter choice-->
					<dsp:a href="interests.jsp">see all interests with even ratings
     						<dsp:param name="filter" value="0" />
					</dsp:a><br/>
					<dsp:a href="interests.jsp">see all interests with odd ratings
     						<dsp:param name="filter" value="1" />
					</dsp:a><br/>
					<dsp:a href="interests.jsp">see all interests
     						<dsp:param name="filter" value="2" />
					</dsp:a><br/>
					<!--end of filter choice-->

					<!-- list of interests -->
					<dsp:droplet name="/dynamusic/ProfileInterestsDroplet">
						<dsp:param name="array" bean="Profile.interests" />
						<dsp:param name="filter" param="filter" />
						<dsp:param name="sortProperties" value="+name"/>
						<dsp:oparam name="outputStart">
						<b>List of interests:</b><br/>
						</dsp:oparam>
						<dsp:oparam name="output">
							<dsp:a href="interestDetails.jsp">
								<dsp:valueof param="element.name" />
								<dsp:param name="interestId" param="element.repositoryId" />
								<dsp:param name="interestName" param="element.name" />
								<dsp:param name="interestRating" param="element.rating" />
							</dsp:a>: 
							<dsp:valueof param="element.rating" />
							<br />
						</dsp:oparam>
						<dsp:oparam name="outputEnd">
						<br/>
						</dsp:oparam>
						</td>
					</dsp:droplet>
					<!-- end of list of interests -->

					<dsp:form action="interests.jsp" method="post">
						<table>
							<tr>
								<td>interest name:</td>
								<td><dsp:input type="text" bean="InterestsFormHandler.interestName"></dsp:input></td>
							</tr>
							<tr>
								<td>interest rating:</td>
								<td><dsp:input type="text" bean="InterestsFormHandler.interestRating"></dsp:input></td>
							</tr>
							<tr>
								<dsp:input  bean="InterestsFormHandler.addInterestSuccessURL" type="hidden" value="interests.jsp"/>
							     <dsp:input  bean="InterestsFormHandler.addInterestErrorURL" type="hidden" value="interests.jsp"/>
								<td><dsp:input type="submit" value="Add interest" bean="InterestsFormHandler.add"></dsp:input></td>
							</tr>
							
						</table>
					</dsp:form>
					
				</tr>
			</table>



			<!-- *** End real content *** --> </font></td>
		</tr>
	</table>
	</BODY>
	</HTML>
</dsp:page>

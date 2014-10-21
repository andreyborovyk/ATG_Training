<%@ taglib uri="/dspTaglib" prefix="dsp"%>
<dsp:page>
	<dsp:importbean bean="/atg/userprofiling/Profile" />
	<dsp:importbean bean="/dynamusic/FeaturedSongs" />
	<dsp:importbean bean="/dynamusic/InterestsFormHandler" />
	<dsp:importbean bean="/dynamusic/ProfileInterestsDroplet" />

	<HTML>
	<HEAD>
	<TITLE>Dynamusic Interest Details</TITLE>
	</HEAD>
	<BODY>
	<dsp:include page="common/header.jsp">
		<dsp:param name="pagename" value="Interest Details" />
	</dsp:include>
	


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
					


					
					
				</tr>
			</table>
			
			<dsp:form action="interestDetails.jsp" method="post">
						<table>
							<tr>
								<td>interest name:</td>
								<td><dsp:input type="text" bean="InterestsFormHandler.interestName" paramvalue="interestName"></dsp:input></td>
							</tr>
							<tr>
								<td>interest rating:</td>
								<td><dsp:input type="text" bean="InterestsFormHandler.interestRating" paramvalue="interestRating"></dsp:input></td>
							</tr>
							<tr>
							             <dsp:input bean="InterestsFormHandler.interestId" type="hidden" paramvalue="interestId"/>
							             <dsp:input  bean="InterestsFormHandler.editInterestSuccessURL" type="hidden" value="interests.jsp"/>
							             <dsp:input  bean="InterestsFormHandler.editInterestErrorURL" type="hidden" value="interests.jsp"/>
							             <dsp:input  bean="InterestsFormHandler.deleteInterestSuccessURL" type="hidden" value="interests.jsp"/>
							             <dsp:input  bean="InterestsFormHandler.deleteInterestErrorURL" type="hidden" value="interests.jsp"/>
								<td><dsp:input type="submit" value="Submit" bean="InterestsFormHandler.edit"></dsp:input></td>
								<td><dsp:input type="submit" value="Delete" bean="InterestsFormHandler.delete"></dsp:input></td>
							</tr>
							
						</table>
					</dsp:form>


			<!-- *** End real content *** --> </font></td>
		</tr>
	</table>
	</BODY>
	</HTML>
</dsp:page>

<%@ include file="/html/portlet/tvtracker/tvtpublic/init.jsp" %>

<%
	TvTrackerPublicDisplayTerms displayTerms = new TvTrackerPublicDisplayTerms(renderRequest);
%>

<aui:nav-bar>
	<aui:nav-bar-search cssClass="form-search pull-right">
		<liferay-ui:search-toggle 
		buttonLabel="search" 
		displayTerms="<%= displayTerms %>" 
		id="toggle_id_tv_tracker_public_search" >
			
			<aui:input 
				label="<%= TvTrackerPublicDisplayTerms.TVSHOW_TITLE %>" 
				name="<%= TvTrackerPublicDisplayTerms.TVSHOW_TITLE %>" 
				size="20" 
				type="text"/>
				
			<aui:input 
				label="<%= TvTrackerPublicDisplayTerms.TVSHOW_DESCRIPTION %>" 
				name="<%= TvTrackerPublicDisplayTerms.TVSHOW_DESCRIPTION %>" 
				size="20" 
				type="text"/>
				
			<div class="wt-field-wrapper">
				<aui:select 
					cssClass="wt-date-field" 
					ignoreRequestValue="true" 
					inlineField="true" 
					label="Premier Year" 
					name="<%= TvTrackerPublicDisplayTerms.DATE_RANGE_TYPE %>">

					<%
						for (DateRangeType dateRangeType : DateRangeType.values()) {
					%>
						<aui:option 
							label="<%= dateRangeType.toString() %>" 
							selected="<%= displayTerms.getDateRangeType() == dateRangeType.getKey() %>" 
							value="<%= dateRangeType.getKey() %>" />
	
					<%
						}
					%>

				</aui:select>
			</div>
			
			<div class='wt-date-fields'>
				
				<%
					String fromClass = 
										(
											(displayTerms.getDateRangeType() == DateRangeType.ANYTIME.getKey()) || 
											(displayTerms.getDateRangeType() == DateRangeType.DATE_TO.getKey())
										) ? "aui-helper-hidden" : StringPool.BLANK;
				%>
				<div class='aui-field aui-field-wrapper wt-field-wrapper wt-datetime-field-wrapper <%= fromClass %>' id="<portlet:namespace />premierYearFrom">
					<div class="aui-field-wrapper-content">
						<aui:input 
							label="premier-year-interval-from" 
							max="<%= displayTerms.getYearRangeEnd() %>" 
							min="<%= displayTerms.getYearRangeStart() %>" 
							name="<%= TvTrackerPublicDisplayTerms.START_DATE_YEAR %>" 
							size="20" 
							type="number" 
							value="<%= displayTerms.getStartDateYear() %>" />
					</div>
				</div>
	
				<div class="clear"></div>
				
				<%
					String toClass = 
									(
										(displayTerms.getDateRangeType() == DateRangeType.ANYTIME.getKey()) || 
										(displayTerms.getDateRangeType() == DateRangeType.DATE_FROM.getKey())
									) ? "aui-helper-hidden" : StringPool.BLANK;
				%>
				<div class='aui-field aui-field-wrapper wt-field-wrapper wt-datetime-field-wrapper <%= toClass %>' id="<portlet:namespace/>premierYearTo">
					<div class="aui-field-wrapper-content">
						<aui:input 
							label="premier-year-interval-to" 
							max="<%= displayTerms.getYearRangeEnd() %>" 
							min="<%= displayTerms.getYearRangeStart() %>" 
							name="<%= TvTrackerPublicDisplayTerms.END_DATE_YEAR %>" 
							size="20" 
							type="number" 
							value="<%= displayTerms.getEndDateYear() %>" />
					</div>
				</div>
			</div>
			
		</liferay-ui:search-toggle>
	</aui:nav-bar-search>
</aui:nav-bar>

<aui:script>
	Liferay.Util.toggleSelectBox(
			"<portlet:namespace /><%= TvTrackerPublicDisplayTerms.DATE_RANGE_TYPE %>", 
			function(currentValue, value) { 
				return (currentValue == <%= DateRangeType.BETWEEN.getKey() %>) || 
					(currentValue == <%= DateRangeType.DATE_FROM.getKey() %>); 
			}, 
			"<portlet:namespace />premierYearFrom");
	
	Liferay.Util.toggleSelectBox(
			"<portlet:namespace /><%= TvTrackerPublicDisplayTerms.DATE_RANGE_TYPE %>",
			function(currentValue, value) { 
				return (currentValue == <%= DateRangeType.BETWEEN.getKey() %>) || 
					(currentValue == <%= DateRangeType.DATE_TO.getKey() %>); 
			}, 
			"<portlet:namespace />premierYearTo");
</aui:script>
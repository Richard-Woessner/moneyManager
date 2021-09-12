# moneyManager
<h1>About Money Manager</h1>
<h2 id="intro">Introduction</h2>
<h2 id="storyboard">Storyboard</h2>
<h2 id="requirements">Functional Requirements</h2>
<h3>Requirement 100.0: Store, View and Edit Income</h3>
<h4>Scenario</h4>
<p>As a User, I want to be able to enter the various incomes that are available to me into the application to store it, so that I can view it or edit it later. This data should be available to other parts of the application for data comparisons.</p>
<p><strong>Examples:</strong></p>
<div style="margin-left:20px;">
   <p><strong>1.1</strong></p>
   <p><strong>Given</strong> I have no stored income data in the application</p>
   <p><strong>When</strong> I open the Money Manager Application</p>
   <p><strong>Then</strong> I should be notified that I have no existing income data and I should be prompted to enter new income data</p>
   <p><strong>1.2</strong></p>
   <p><strong>Given</strong> I enter a new income item</p>
   <p><strong>Then</strong> I should be prompted to select the relevant additional information (e.g., amount, frequency, etc.)</p>
   <p><strong>1.3</strong></p>
   <p><strong>Given</strong> I have previously stored income data in the application</p>
   <p><strong>When</strong> I choose the View Income option</p>
   <p><strong>Then</strong> my stored income data should be displayed in the application</p>
   <p><strong>1.4</strong></p>
   <p><strong>Given</strong> I have previously stored income data in the application</p>
   <p><strong>Given</strong> I am viewing previously stored income data</p>
   <p><strong>When</strong> I choose the Edit option for any given income entry</p>
   <p><strong>Then</strong> each previously entered field for that income should be editable</p>
   <p><strong>1.5</strong></p>
   <p><strong>Given</strong> I have previously stored income data in the application</p>
   <p><strong>Given</strong> I am viewing previously stored income data</p>
   <p><strong>When</strong> I choose the Delete option for any given income entry</p>
   <p><strong>Then</strong> the income item should be marked as deleted and removed from the list of income items</p>
   <p><strong>1.6</strong></p>
   <p><strong>Given</strong> a stored income item is already existing in the Money Management Application</p>
   <p><strong>When</strong> I attempt to add the item again</p>
   <p><strong>Then</strong> I should receive a prompt notifying me that the item is already on the list with the option to cancel my entry, update the previously entry or add a duplicate item.</p>
</div>
<h3>Requirement 101.0: Store, View and Edit Debts &amp; Bills</h3>
<h4>Scenario</h4>
<p>As a User, I want to be able to enter the various debts and bills that I need to pay into the application to store it, so that I can view it or edit it later. This data should be available to other parts of the application for data comparisons.</p>
<div style="margin-left:20px;">
   <p><strong>1.1</strong></p>
   <p><strong>Given</strong> I have previously stored income data in the application</p>
   <p><strong>Given</strong> I have no stored bills data in the application</p>
   <p><strong>When</strong> I open the Money Management Application</p>
   <p><strong>Then</strong> I should be notified that I have not existing bill data and I should be prompted to enter new bill data</p>
   <p><strong>1.2</strong></p>
   <p><strong>Given</strong> I enter a new bill item</p>
   <p><strong>Then</strong> I should be prompted to select the relevant additional information (e.g., amount, frequency, etc.)</p>
   <p><strong>1.3</strong></p>
   <p><strong>Given</strong> I have previously stored bill data in the application</p>
   <p><strong>When</strong> I choose the View Bill option</p>
   <p><strong>Then</strong> my stored bill data should be displayed in the application</p>
   <p><strong>1.4</strong></p>
   <p><strong>Given</strong> I have previously stored bill data in the application</p>
   <p><strong>Given</strong> I am viewing previously stored bill data</p>
   <p><strong>When</strong> I choose the Edit option for any given bill entry</p>
   <p><strong>Then</strong> each previously entered field for that bill should be editable</p>
   <p><strong>1.5</strong></p>
   <p><strong>Given</strong> I have previously stored bill data in the application</p>
   <p><strong>Given</strong> I am viewing previously stored bill data</p>
   <p><strong>When</strong> I choose the Delete option for any given bill entry</p>
   <p><strong>Then</strong> the bill item should be marked as deleted and removed from the list of bills</p>
   <p><strong>1.6</strong></p>
   <p><strong>Given</strong> a stored bill item is already existing in the Money Management Application</p>
   <p><strong>When</strong> I attempt to add the item again</p>
   <p><strong>Then</strong> I should receive a prompt notifying me that the item is already on the list with the option to cancel my entry, update the previously entry or add a duplicate item.</p>
</div>
<h3>Requirement 102.0: View a Summary of Income and Bills with a Debt-to-Income Ratio Graph</h3>
<h4>Scenario</h4>
<p>As a User, I want to be able to see a summary of my total income vs my total bills with a graphical interface that gives a visual representation of the summary.</p>
<h4>Dependencies</h4>
<p>Income and Bill items have been entered previously in the Money Management Application</p>
<div style="margin-left:20px;">
   <p><strong>1.1</strong></p>
   <p><strong>Given</strong> I open the Money Management Application</p>
   <p><strong>Then</strong> I should see a summary of my previously entered income and bill items with a nice GUI highlighting the totals from each category</p>
   <p><strong>1.2</strong></p>
   <p><strong>Given</strong> I am viewing the Summary Menu</p>
   <p><strong>When</strong> I select Income Details</p>
   <p><strong>Then</strong> I should see a list of previously entered income items</p>
   <p><strong>1.3</strong></p>
   <p><strong>Given</strong> I am viewing the Summary Menu</p>
   <p><strong>When</strong> I select Bill Details</p>
   <p><strong>Then</strong> I should see a list of previously entered bill items</p>
</div>
<h3>Requirement 103.0: Generate Suggestions for Savings</h3>
<h4>Scenario</h4>
<p>As a User, I want to be able to use the Money Management Application to identify potential savings in my bills.</p>
<h4>Dependencies</h4>
<p>Recipes have previously been saved or favorited in the Money Management Application.</p>
<div style="margin-left:20px;">
   <p><strong>1.1</strong></p>
   <p><strong>Given</strong> I am viewing the Summary Menu</p>
   <p><strong>When</strong> I choose Find Savings</p>
   <p><strong>Then</strong> I should see a list of non-essential bills displayed with their total monthly cost</p>
</div>
<h2 id="diagram">Class Diagram</h2>

<h2 id="json">JSON Schema</h2>
<h2 id="roles">Scrum Roles</h2>
<ul>
<li>Alainna Nichols - Business Logic</li>
<li>Mamadou Kone - UI Specialist</li>
<li>Richard Woessner -  Scrum master</li>
<li>Juan Lopez Rosado - Developer</li>
</ul>
<h2 id="github">Github URL</h2>
<h3><a href="https://github.com/Richard-Woessner/moneyManager" target="_blank">Money Manager on GitHub</a></h3>
<h2 id="scrum">Scrum Board</h2>
<h3><a href="https://trello.com/b/zgP0FG7V/moneymanager" target="_blank">Our Board in Trello</a></h3>
<h2 id="teams">Link to Teams</h2>
<h3><a href="https://teams.microsoft.com/l/meetup-join/19%3ameeting_N2I0NzliMzgtNTNiOS00MWU2LWJlZmUtMjAxYTM5MGM4MTZm%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%224e12a843-0809-4a17-b8d9-7017f7b12776%22%7d" target="_blank">Teams Meeting</a></h3>

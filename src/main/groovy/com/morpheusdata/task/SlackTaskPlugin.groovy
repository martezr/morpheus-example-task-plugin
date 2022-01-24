package com.morpheusdata.task

import com.morpheusdata.core.Plugin
import com.morpheusdata.model.Permission
import com.morpheusdata.views.HandlebarsRenderer
import com.morpheusdata.views.ViewModel
import com.morpheusdata.web.Dispatcher
import com.morpheusdata.model.OptionType

class SlackTaskPlugin extends Plugin {

	@Override
	String getCode() {
		return 'slack-task-plugin'
	}

	@Override
	void initialize() {
		SlackTaskProvider slackTaskProvider = new SlackTaskProvider(this, morpheus)
		this.pluginProviders.put(slackTaskProvider.code, slackTaskProvider)
		this.setName("Slack Task Plugin")
		this.setDescription("Example plugin for custom tasks")
		this.setAuthor("Martez Reed")
		this.setSourceCodeLocationUrl("https://github.com/martezr/morpheus-example-task-plugin")
		this.setIssueTrackerUrl("https://github.com/martezr/morpheus-example-task-plugin/issues")
		this.setPermissions([Permission.build('Slack Task','slack-task-view', [Permission.AccessType.none, Permission.AccessType.full])])

		// Plugin settings the are used to configure the behavior of the plugin
		// https://developer.morpheusdata.com/api/com/morpheusdata/model/OptionType.html
		this.settings << new OptionType(
			name: 'Slack Token',
			code: 'slack-task-plugin-token',
			fieldName: 'slackToken',
			displayOrder: 0,
			fieldLabel: 'Slack Token',
			helpText: 'The Slack Token used to send messages',
			required: true,
			inputType: OptionType.InputType.PASSWORD
		)
        }
	@Override
	void onDestroy() {}
}

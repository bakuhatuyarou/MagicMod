package MagicMod;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessagePlayerPropertiesHandler implements IMessageHandler<MessagePlayerProperties, IMessage> {

	@Override
	public IMessage onMessage(MessagePlayerProperties message, MessageContext ctx) {
		//Client側にIExtendedEntityPropertiesを渡す。
		ExtendedPlayerProperties.get(MagicMod.proxy.getEntityPlayerInstance()).loadNBTData(message.data);
		//REPLYは送らないので、nullを返す。
		return null;
	}
}

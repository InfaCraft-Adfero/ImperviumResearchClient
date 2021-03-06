package icac.irc.client.networking.server;

import icac.irc.client.datatypes.UInt8;
import icac.irc.client.datatypes.sVLQ;
import icac.irc.client.networking.IPacket;
import icac.irc.client.networking.PacketPayload;
import icac.irc.client.networking.StarboundInputStream;
import icac.irc.client.networking.StarboundOutputStream;

public class PacketProtocolVersion implements IPacket {

	public PacketPayload payload = new PacketPayload();
	private int protocolVersion;
	
	public PacketProtocolVersion() {
	}
	
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)0);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		//Server->Client Packet.
	}

	@Override
	public void read(StarboundInputStream sis) throws Exception {
		payload.setBytes(new sVLQ(sis.readByte()).getBytes());
		this.protocolVersion = sis.readInt();
	}
	
	public int getProtocolVersion() {
		return this.protocolVersion;
	}

}
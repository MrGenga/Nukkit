package cn.nukkit.network.protocol;

import cn.nukkit.raknet.protocol.EncapsulatedPacket;
import cn.nukkit.utils.BinaryStream;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public abstract class DataPacket extends BinaryStream implements Cloneable {

    public boolean isEncoded = false;
    private int channel = 0;

    public EncapsulatedPacket encapsulatedPacket;
    public byte reliability;
    public Integer orderIndex = null;
    public Integer orderChannel = null;

    public abstract byte pid();

    public abstract void decode();

    public abstract void encode();

    @Override
    public byte[] getBuffer() {
        return super.getBuffer();
    }

    @Override
    public void reset() {
        super.reset();
        this.putByte(this.pid());
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public int getChannel() {
        return channel;
    }

    public DataPacket clean() {
        this.setBuffer(null);

        this.isEncoded = false;
        this.offset = 0;
        return this;
    }

    @Override
    public DataPacket clone() {
        try {
            return (DataPacket) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

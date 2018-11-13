package simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for(int i=0;i<100;i++) {
            System.out.println(i);
            ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!"+i,
                    CharsetUtil.UTF_8));
        }
    }


    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        System.out.println(
                "Client received:" + in.toString(CharsetUtil.UTF_8)
        );
    }
}
